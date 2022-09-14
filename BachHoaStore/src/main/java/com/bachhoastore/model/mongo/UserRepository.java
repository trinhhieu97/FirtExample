package com.bachhoastore.model.mongo;
import com.bachhoastore.model.IUserRepository;
import com.bachhoastore.model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class UserRepository implements IUserRepository {
    private static final String USER_COLLECTION = "users";
    private static final String USER_DATABASE = "myDb";
    ConnectToDB connectToDB = new ConnectToDB();
    MongoDatabase database = connectToDB.connectToDB().getDatabase(USER_DATABASE);
    MongoCollection<Document> collection;

    public MongoCollection<Document> getCollection() {
        if (collection == null) {
            collection = database.getCollection(USER_COLLECTION);
        }
        return collection;
    }

    public void insertUser(User user) {
        Document document = new Document("name", user.getName())
                .append("birthday", user.getBirthday())
                .append("sex", user.getSex())
                .append("email", user.getEmail())
                .append("mobile", user.getMobile())
                .append("password", user.getPassword());
        getCollection().insertOne(document);
    }

    public User editUser(String mobile, User user) {
        Document document = new Document();
        append(document,"name",user.getName());
        append(document,"birthday",user.getBirthday());
        append(document,"email",user.getEmail());
        append(document,"mobile",user.getMobile());
        append(document,"password",user.getPassword());
        if (user.getSex() != 0) {
            document.append("sex", user.getSex());
        }
        Bson query =  Filters.eq("mobile", mobile);
        Document command = new Document("$set", document);
        getCollection().updateOne(query, command);
        return user;
    }
    @Override
    public boolean deleteUser(String mobile) {
        getCollection().deleteOne(Filters.eq("mobile", mobile));
        return true;
    }

    @Override
    public List<User> searchUserByName(String name) {
        List<User> list = loadAllUsers();
        List<User> list1 = new ArrayList<User>();
        int start = 0;
        User user;
        int a = 0;
        while (start < list.size()) {
            user = list.get(start);
            String mo = user.getName();
            if (mo.toLowerCase().contains(name.toLowerCase())) {
                list1.add(user);
            }
            start++;
        }
        return list1;
    }

    @Override
    public List<User> searchUserByMobile(String mobile) {
        List<User> list = loadAllUsers();
        List<User> list1 = new ArrayList<User>();
        int start = 0;
        User user;
        int a = 0;
        while (start < list.size()) {
            user = list.get(start);
            String mo = user.getMobile();
            if (mo.startsWith(mobile)) {
                list1.add(user);
            }
            start++;
        }
        return list1;
    }

    @Override
    public List<String> SortUserName() {
        List<User> list = loadAllUsers();
        List<String> listName = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            listName.add(i,list.get(i).getName());
        }
        Collections.sort(listName);
        return listName;
    }

    @Override
    public List<User> addUsers(ArrayList<User> user) {
        List<Document> user1 = new ArrayList<>();
        Document document;
        for (int i = 0; i < user.size(); i++){
            document = castUserToDocument(user.get(i));
            user1.add(document);
        }
        getCollection().insertMany(user1);
        return loadAllUsers();
    }

    @Override
    public void addUser(User user) {
        Document document = castUserToDocument(user);
        getCollection().insertOne(document);
    }
    private Document castUserToDocument(User user) {
        Document document = new Document("name", user.getName());
        append(document, "birthday", user.getBirthday());
        append(document, "sex", user.getSex());
        append(document, "email", user.getEmail());
        append(document, "mobile", user.getMobile());
        append(document, "password", user.getPassword());
        return document;
    }

    private Document append(Document document, String key, Object value) {
        if (value != null) {
            document.append(key, value);
        }
        return document;
    }

    @Override
    public List<User> loadAllUsers() {
        List<User> users = new ArrayList<>();
        try (MongoCursor<Document> cursor = getCollection().find().cursor()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                User user = castDocumentToUser(document);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User findUserByMobile(String mobile) {
        try (MongoCursor<Document> cursor = getCollection().find(Filters.eq("mobile", mobile)).limit(1).cursor()) {
            if (cursor.hasNext()) {
                Document document = cursor.next();
                return castDocumentToUser(document);
            }
        }
        return null;
    }
    private User castDocumentToUser(Document document) {
        User user = new User();
        user.setName(document.getString("name"));
        user.setBirthday(document.getString("birthday"));
        user.setSex(document.getInteger("sex"));
        user.setEmail(document.getString("email"));
        user.setMobile(document.getString("mobile"));
        user.setPassword(document.getString("password"));
        return user;
    }
}

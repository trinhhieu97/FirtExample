package com.bachhoastore.services;

import com.bachhoastore.controllers.LoginDto;
import com.bachhoastore.model.mongo.UserRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImp implements AuthenticationService {
    @Autowired
    JwtService jwtService;
    UserRepository userRepository = new UserRepository();

    @Override
    public String login(LoginDto loginDto) {
        String token;
        if (checkExists(loginDto)) {
             token = jwtService.generateTokenLogin(loginDto.getEmail());
        } else {
            throw new RuntimeException("account not void");
        }
        return token;
}
    @Override
    public boolean checkExists(LoginDto loginDto) {
        Document document = new Document()
                .append("email", loginDto.getEmail())
                .append("password", loginDto.getPassword());
        MongoCursor<Document> cursor =  userRepository.getCollection().find(document).cursor();
        if (cursor.hasNext()) {
            return true;
        } else {
            return false;
        }
    }
}

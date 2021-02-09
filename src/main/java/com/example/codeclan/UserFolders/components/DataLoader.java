package com.example.codeclan.UserFolders.components;

import com.example.codeclan.UserFolders.models.File;
import com.example.codeclan.UserFolders.models.Folder;
import com.example.codeclan.UserFolders.models.User;
import com.example.codeclan.UserFolders.repositories.FileRepository;
import com.example.codeclan.UserFolders.repositories.FolderRepository;
import com.example.codeclan.UserFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public DataLoader() {
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        User TomBrady = new User("Tom Brady");
        userRepository.save(TomBrady);

        Folder touchdown = new Folder("Touchdown Plays", TomBrady);
        folderRepository.save(touchdown);
        Folder offensive = new Folder("Offensive Formations", TomBrady);
        folderRepository.save(offensive);
        Folder defensive = new Folder("Defensive Formations", TomBrady);
        folderRepository.save(defensive);
        Folder training = new Folder("Training Schedule", TomBrady);
        folderRepository.save(training);

        File touchdown_record = new File("Touchdowns", "xls", 1000, touchdown);
        fileRepository.save(touchdown_record);
        File wildcat = new File( "Wildcat Formation", ".pdf", 900, offensive);
        fileRepository.save(wildcat);
        File shotgun = new File("Shotgun Formation", ".ppt", 1000, offensive);
        fileRepository.save(shotgun);
        File nickel = new File("Nickel Defence", ".ppt", 800, defensive);
        fileRepository.save(nickel);
        File dime = new File("Dime Formation", ".txt", 1000, defensive);
        fileRepository.save(dime);
    }
}

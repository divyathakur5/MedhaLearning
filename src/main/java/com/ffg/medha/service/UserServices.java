package com.ffg.medha.service;

import com.ffg.medha.model.UserDetails;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Data
@Service
@Slf4j
public class UserServices {


    public String signIn(UserDetails userDetails) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =
                dbFirestore.collection("students")
                .document(userDetails.getEmail());
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        if(document.exists()) {
            if(userDetails.getPassword().equals(document.get("password"))){
                if(document.get("needsNgoApproval").equals(true)){
                    return "Awaiting Admin Approval for registration!";
                }
                return "Sign-in successfull";
            }
        }
        return "User not registered";
    }

}

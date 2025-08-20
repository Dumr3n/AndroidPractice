    package com.example.firestoreapp;

import android.icu.util.Freezable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

    public class MainActivity extends AppCompatActivity {
    private Button saveBtn;
    private Button readBtn;
    private Button updateBtn;
    private Button deleteBtn;
    private TextView testView;
    private EditText name;
    private EditText email;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference friendReference = db.collection("Users").document("CIfJ6SBcwUAAeSxFcy5M");
    private CollectionReference collectionReference = db.collection("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name = findViewById(R.id.nameText);
        email = findViewById(R.id.emailText);
        saveBtn = findViewById(R.id.save);
        readBtn = findViewById(R.id.read);
        updateBtn = findViewById(R.id.update);
        deleteBtn = findViewById(R.id.delete);
        testView = findViewById(R.id.textTest);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveDataToNewDoc();
            }
        });
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetAllDocumentsInCollection();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateSpecificDocument();
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteSpecificDocument();
            }
        });
    }
    public void SaveDataToNewDoc() {
        String nametxt = name.getText().toString();
        String emailtxt = email.getText().toString();
        Friend friend = new Friend(nametxt, emailtxt);
        collectionReference.add(friend).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                String docId = documentReference.getId();
            }
        });
    }

    private void GetAllDocumentsInCollection() {
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String data = "";
                 for (QueryDocumentSnapshot snapshot : queryDocumentSnapshots) {
                     Friend friend = snapshot.toObject(Friend.class);
                     data += "Name: " + friend.getName() + " email: " + friend.getEmail() + "\n";
                 }
                 testView.setText(data);

            }
        });
    }
    public void UpdateSpecificDocument() {
        String nametxt = name.getText().toString();
        String emailtxt = email.getText().toString();
        friendReference.update("name", nametxt);
        friendReference.update("email", emailtxt);
    }

        public void DeleteSpecificDocument() {
            friendReference.delete();
        }
}
package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class FormActivity extends AppCompatActivity {

    private EditText email, password, password_confirm, name;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.NameEntry);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.passwordEntry);
        password_confirm = findViewById(R.id.confirmPass);
        save = findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkData();
            }
        });
    }

    boolean checkField(EditText input) {
        if (input.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    boolean checkPass(EditText input, EditText input2) {
        String pass = input.getText().toString();
        String pass2 = input2.getText().toString();
        if (pass.equals(pass2)) {
            return true;
        }
        return false;
    }

    void checkData() {
        if(!checkField(name) || !checkField(email) || !checkField(password) || !checkField(password_confirm)) {
            Toast t = Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT);
            t.show();
        } else {
            if(!checkPass(password, password_confirm)) {
                Toast t = Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT);
                t.show();
            } else {
                Toast t = Toast.makeText(this, "Welcome, " + name.getText().toString() + ", to the SignUpFrom App.", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

}

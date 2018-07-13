package technology.dxc.roboletricunittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtNumber1)
    EditText txtNumber1;
    @BindView(R.id.txtNumber2)
    EditText txtNumber2;
    @BindView(R.id.lblResult)
    TextView lblResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.cmdMinus)
    protected void cmdMinus_Click() {
        Integer num1 = Integer.parseInt(txtNumber1.getText().toString());
        Integer num2 = Integer.parseInt(txtNumber2.getText().toString());
        Integer res = 0;
        res = num1 - num2;
        lblResult.setText(res.toString());
    }

    @OnClick(R.id.cmdAdd)
    protected void cmdAdd_Click() {
        Integer num1 = Integer.parseInt(txtNumber1.getText().toString());
        Integer num2 = Integer.parseInt(txtNumber2.getText().toString());
        Integer res = 0;
        res = num1 + num2;
        lblResult.setText(res.toString());
    }
}

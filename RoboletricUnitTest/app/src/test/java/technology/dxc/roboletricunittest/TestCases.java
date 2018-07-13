package technology.dxc.roboletricunittest;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
public class TestCases {
    private MainActivity mainact;
    @Before
    public void InitApp(){
        mainact = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void TestCase1_DisplayWithoutError(){
        Assert.assertEquals( mainact.getTitle(),"Roboletric Unit Test");

    }
    @Test
    public void TestCase2_ButtonAddHasTextAdd(){
        Button cmdAdd = mainact.findViewById(R.id.cmdAdd);
        Assert.assertEquals(cmdAdd.getText(),"Add");
    }

    @Test
    public void TestCase3_Add2UnSignNumber(){
        Button cmdAdd = mainact.findViewById(R.id.cmdAdd);
        EditText txtNumber1 = mainact.findViewById(R.id.txtNumber1);
        EditText txtNumber2 = mainact.findViewById(R.id.txtNumber2);
        TextView lblResult = mainact.findViewById(R.id.lblResult);

        txtNumber1.setText("1");
        txtNumber2.setText("2");
        cmdAdd.performClick();
        Assert.assertEquals(lblResult.getText(),"3");
    }
    @Test
    public void TestCase4_Add2SignNumber(){
        Button cmdAdd = mainact.findViewById(R.id.cmdAdd);
        EditText txtNumber1 = mainact.findViewById(R.id.txtNumber1);
        EditText txtNumber2 = mainact.findViewById(R.id.txtNumber2);
        TextView lblResult = mainact.findViewById(R.id.lblResult);

        txtNumber1.setText("-1");
        txtNumber2.setText("-2");
        cmdAdd.performClick();
        Assert.assertEquals(lblResult.getText(),"-3");
    }

    @Test
    public void TestCase5_Minus2SignNumber(){
        Button cmdMinus = mainact.findViewById(R.id.cmdMinus);
        EditText txtNumber1 = mainact.findViewById(R.id.txtNumber1);
        EditText txtNumber2 = mainact.findViewById(R.id.txtNumber2);
        TextView lblResult = mainact.findViewById(R.id.lblResult);

        txtNumber1.setText("-1");
        txtNumber2.setText("-2");
        cmdMinus.performClick();
        Assert.assertEquals(lblResult.getText(),"1");
    }

    @Test
    public void TestCase6_Minus2UnSignNumber(){
        Button cmdMinus = mainact.findViewById(R.id.cmdMinus);
        EditText txtNumber1 = mainact.findViewById(R.id.txtNumber1);
        EditText txtNumber2 = mainact.findViewById(R.id.txtNumber2);
        TextView lblResult = mainact.findViewById(R.id.lblResult);

        txtNumber1.setText("1");
        txtNumber2.setText("2");
        cmdMinus.performClick();
        Assert.assertEquals(lblResult.getText(),"-1");
    }
}

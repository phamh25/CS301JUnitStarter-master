package up.edu.dimcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DimCalc extends AppCompatActivity implements View.OnClickListener {

    /* This is our model containing the two points the user is manipulating */
    private TwoPoints twoPoints = new TwoPoints();

    /* The current result string for the user */
    private String result = "";

    /* These variables refer to views we'll be manipulating.  They are initialized in onCreate() */
    private EditText x1EditText;
    private EditText y1EditText;
    private EditText x2EditText;
    private EditText y2EditText;
    private TextView resultTextView;

    /** startup method for this app.  Inflates the GUI and initializes the app */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dim_calc);

        //init view references
        x1EditText = (EditText)findViewById(R.id.X1editText);
        y1EditText = (EditText)findViewById(R.id.Y1editText);
        x2EditText = (EditText)findViewById(R.id.X2editText);
        y2EditText = (EditText)findViewById(R.id.Y2editText);
        resultTextView = (TextView)findViewById(R.id.resultTextView);

        //Tell me when the user presses a button
        int[] ids = {R.id.rand1Button, R.id.rand2Button, R.id.origin1Button, R.id.origin2Button,
                     R.id.copy1Button, R.id.copy2Button, R.id.distanceButton, R.id.slopeButton };
        for(int i = 0; i < ids.length; ++i) {
            Button b = (Button)findViewById(ids[i]);
            b.setOnClickListener(this);
        }

        //show the user the current values
        updateDisplayFromModel();

    }//onCreate

    /** updates the values displayed to the user */
    private void updateDisplayFromModel() {
        x1EditText.setText("" + twoPoints.getPoint(0).x);
        y1EditText.setText("" + twoPoints.getPoint(0).y);
        x2EditText.setText("" + twoPoints.getPoint(1).x);
        y2EditText.setText("" + twoPoints.getPoint(1).y);
        resultTextView.setText(result);
    }

    /** extracts the values in the GUI and puts them in the model */
    private void updateModelFromDisplay() {
        int x1 = Integer.parseInt(x1EditText.getText().toString());
        int y1 = Integer.parseInt(y1EditText.getText().toString());
        int x2 = Integer.parseInt(x2EditText.getText().toString());
        int y2 = Integer.parseInt(y2EditText.getText().toString());
    }

    /** respond to button presses on the GUI */
    @Override
    public void onClick(View v) {

        //get the latest values from the display
        updateModelFromDisplay();

        result = "";  //default is no result

        //Respond to the button press
        int id = v.getId();
        switch(id) {
            case R.id.rand1Button:
                twoPoints.randomValue(0);
                break;
            case R.id.origin1Button:
                twoPoints.setOrigin(0);
                break;
            case R.id.rand2Button:
                twoPoints.randomValue(1);
                break;
            case R.id.origin2Button:
                twoPoints.setOrigin(1);
                break;
            case R.id.copy1Button:
                twoPoints.copy(1, 0);
                break;
            case R.id.copy2Button:
                twoPoints.copy(0,1);
                break;
            case R.id.distanceButton:
                result = "" + twoPoints.distance();
                break;
            case R.id.slopeButton:
                result = "" + twoPoints.slope();
                break;
            default:
                break;
        }//switch

        updateDisplayFromModel();
    }//onClick

}//class DimCalc

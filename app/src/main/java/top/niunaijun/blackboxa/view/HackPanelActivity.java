package top.niunaijun.blackboxa.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ToggleButton;
import top.niunaijun.blackboxa.R;

public class HackPanelActivity extends Activity {

    static {
        System.loadLibrary("native-lib");
    }

    public native void toggleESP(boolean enable);
    public native void toggleAimbot(boolean enable);
    public native void toggleSpeed(boolean enable);
    public native void toggleAntiBan(boolean enable);
    public native void activateAllHacks();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack_panel);

        // लॉन्च होते ही सारे हैक्स ON
        activateAllHacks();

        ToggleButton esp = findViewById(R.id.espToggle);
        esp.setOnCheckedChangeListener((btn, isChecked) -> toggleESP(isChecked));

        ToggleButton aim = findViewById(R.id.aimbotToggle);
        aim.setOnCheckedChangeListener((btn, isChecked) -> toggleAimbot(isChecked));

        ToggleButton speed = findViewById(R.id.speedToggle);
        speed.setOnCheckedChangeListener((btn, isChecked) -> toggleSpeed(isChecked));

        ToggleButton anti = findViewById(R.id.antiBanToggle);
        anti.setOnCheckedChangeListener((btn, isChecked) -> toggleAntiBan(isChecked));
    }
}
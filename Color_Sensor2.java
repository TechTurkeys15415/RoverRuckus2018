package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous (name = "Color_Sensor Output2")



public class Color_Sensor2 extends LinearOpMode {
    public ColorSensor Sen1_CS;

    @Override

    public void runOpMode() throws InterruptedException{


        Sen1_CS = hardwareMap.get(ColorSensor.class, "Sen1_CS");


        waitForStart();
        while(opModeIsActive()) {

            float hsvValues[] = {0F, 0F, 0F};
            final float values[] = hsvValues;
            Color.RGBToHSV(Sen1_CS.red() * 8, Sen1_CS.green() * 8, Sen1_CS.blue() * 8, hsvValues);
            float hue = hsvValues[0];
            float sat = hsvValues[1];
            float val = hsvValues[2];
            telemetry.addData("Hue:", hue);
            telemetry.addData("Saturation:", sat);
            telemetry.addData("Value", val);
            telemetry.update();



            if((hue > 95 && hue < 115) && (sat > .16 && sat < .24) && (val > .78 && val < 1)){//WHITE
                telemetry.addData("READING","WHITE");
                telemetry.update();
            }

            if((hue > 68 && hue < 88) && (sat > .17 && sat < .3) && (val > .58 && val < .78)){//YELLOW
                telemetry.addData("READING","YELLOW");
                telemetry.update();
            }

        }



    }
}

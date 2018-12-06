package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous (name = "Color_Sensor Output")


public class Color_Sensor extends LinearOpMode {
    public ColorSensor Sen1_CS;

    @Override

    public void runOpMode() throws InterruptedException{


        Sen1_CS = hardwareMap.get(ColorSensor.class, "Sen1_CS");


        waitForStart();
        while(opModeIsActive()) {
            Sen1_CS.enableLed(true);

            telemetry.addData("Alpha", Sen1_CS.alpha());
            telemetry.addData("Red", Sen1_CS.red());
            telemetry.addData("Green", Sen1_CS.green());
            telemetry.addData("Blue", Sen1_CS.blue());
            telemetry.update();

        }



    }
}

package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//Voltage is 13.76 V
@Autonomous (name = "Auto_Crater_EDITED")

public class Auto_Crater_EditThis extends LinearOpMode {
    public ColorSensor Sen1_CS;
    public DcMotor M1_BLW;
    public DcMotor M2_BRW;
    public DcMotor M3_FLS;
    @Override

    public void runOpMode() throws InterruptedException{

        Sen1_CS = hardwareMap.get(ColorSensor.class, "Sen1_CS");
        M1_BLW = hardwareMap.get(DcMotor.class, "M1_BLW");
        M2_BRW = hardwareMap.get(DcMotor.class, "M2_BRW");
        M3_FLS = hardwareMap.get(DcMotor.class, "M3_FLS");

        waitForStart();
        while(opModeIsActive()) {


            M1_BLW.setDirection(DcMotor.Direction.FORWARD);
            M2_BRW.setDirection(DcMotor.Direction.REVERSE);

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


            M1_BLW.setPower(.5);
            M2_BRW.setPower(.5);
            sleep(175);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(-1);
            sleep(100);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(1);
            sleep(100);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            M1_BLW.setPower(1);
            M2_BRW.setPower(.25);
            sleep(500);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            sleep(2000);

            Color.RGBToHSV(Sen1_CS.red() * 8, Sen1_CS.green() * 8, Sen1_CS.blue() * 8, hsvValues);
            hue = hsvValues[0];             //SCANS UNTIL FINDS YELLOW
            sat = hsvValues[1];
            val = hsvValues[2];
            if((hue > 80 && hue < 135/*EDIT THIS VALUE */) && (sat > .16 && sat < .3) && (val > .48 && val < .78)){//YELLOW

                telemetry.addData("READING","YELLOW");
                telemetry.update();
                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(500);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);
                M3_FLS.setPower(-1);
                sleep(500);
                stop();
            }

            else if((hue > 130 && hue < 160) && (sat > .21 && sat < .29) && (val > .48 && val < 1)){//WHITE
                telemetry.addData("READING","WHITE");
                telemetry.update();

                M1_BLW.setPower(0);
                M2_BRW.setPower(-1);
                sleep(600);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);

                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(800);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);
                M3_FLS.setPower(-1);
                sleep(500);
                stop();
            }

            else{
                telemetry.addData("READING","NOTHING");
                telemetry.update();
                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(500);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);
                stop();
            }
            stop();
        }
    }
}

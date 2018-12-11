package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//Voltage is 13.58 V
@Autonomous (name = "Sampling_HSV_Main")

public class Main_Auto_Crater extends LinearOpMode {
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
            sleep(125);
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
            M2_BRW.setPower(.17);
            sleep(500);
            M1_BLW.setPower(0);
            M2_BRW.setPower(0);

            sleep(2000);

//            if((hue > 95 && hue < 115) && (sat > .16 && sat < .24) && (val > .78 && val < 1)){//WHITE
//                telemetry.addData("READING","WHITE");
//                telemetry.update();
//
//                M1_BLW.setPower(0);
//                M2_BRW.setPower(-1);
//                sleep(700);
//                M1_BLW.setPower(0);
//                M2_BRW.setPower(0);
//
//                M1_BLW.setPower(1);
//                M2_BRW.setPower(1);
//                sleep(800);
//                M1_BLW.setPower(0);
//                M2_BRW.setPower(0);
//            }

//            while((hue < 68 && hue > 88) && (sat <.17 && sat > .3) && (val < .54 && val > .78)){
//                Color.RGBToHSV(Sen1_CS.red() * 8, Sen1_CS.green() * 8, Sen1_CS.blue() * 8, hsvValues);
//                hue = hsvValues[0];             //SCANS UNTIL FINDS YELLOW
//                sat = hsvValues[1];
//                val = hsvValues[2];
//
//            }

            Color.RGBToHSV(Sen1_CS.red() * 8, Sen1_CS.green() * 8, Sen1_CS.blue() * 8, hsvValues);
            hue = hsvValues[0];             //SCANS UNTIL FINDS YELLOW
            sat = hsvValues[1];
            val = hsvValues[2];
            if((hue > 68 && hue < 88) && (sat > .17 && sat < .3) && (val > .58 && val < .78)){//YELLOW

                telemetry.addData("READING","YELLOW");
                telemetry.update();
                M1_BLW.setPower(1);
                M2_BRW.setPower(1);
                sleep(500);
                M1_BLW.setPower(0);
                M2_BRW.setPower(0);
                stop();
            }

            else if((hue > 95 && hue < 150) && (sat > .16 && sat < .24) && (val > .78 && val < 1)){
                telemetry.addData("READING","WHITE");
                telemetry.update();

                M1_BLW.setPower(0);
                M2_BRW.setPower(-1);
                sleep(800);
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
//            else if(x == 1){
//                M1_BLW.setPower(0);
//                M2_BRW.setPower(-1);
//                sleep(700);
//                M1_BLW.setPower(0);
//                M2_BRW.setPower(0);
//
//                M1_BLW.setPower(1);
//                M2_BRW.setPower(1);
//                sleep(800);
//                M1_BLW.setPower(0);
//                M2_BRW.setPower(0);
//            }
            stop();
        }
    }
}

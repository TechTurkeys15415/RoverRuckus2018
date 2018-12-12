package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp (name = "TeleOpWorkingv2.java")

public class TeleOpWorkingv2 extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();
    public DcMotor M2_BRW;
    public DcMotor M1_BLW;
    public DcMotor M4_Arm;
    public Servo S1_Basket;
    public DcMotor M3_FLS;
    @Override

    public void runOpMode() throws InterruptedException{
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        M2_BRW = hardwareMap.dcMotor.get("M2_BRW");
        M1_BLW = hardwareMap.dcMotor.get("M1_BLW");
        M4_Arm = hardwareMap.dcMotor.get("M4_Arm");
        S1_Basket = hardwareMap.servo.get("S1_Basket");
        M3_FLS = hardwareMap.dcMotor.get("M3_FLS");
        M1_BLW.setDirection(DcMotor.Direction.REVERSE);
        M2_BRW.setDirection(DcMotor.Direction.FORWARD);
        M4_Arm.setDirection(DcMotor.Direction.FORWARD);
        M3_FLS.setDirection(DcMotor.Direction.FORWARD);
        S1_Basket.setPosition(90);

        double currentbasketPosition;
        currentbasketPosition = S1_Basket.getPosition();


        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double rightPower;
            double leftPower;
            double armPower;
            double basketPosition;

            double turnPower = gamepad1.right_stick_x;
            double drivePower = gamepad1.left_stick_y;
            double elevationPower = gamepad2.right_stick_y;
            double tiltPosition = gamepad2.left_stick_y;

            boolean forwardSweeperPower = gamepad2.y;
            boolean backwardSweeperPower = gamepad2.a;

            leftPower = Range.clip(drivePower - turnPower,-1.0,1.0);
            rightPower = Range.clip(drivePower + turnPower, -1.0,1.0);
            armPower = Range.clip(elevationPower, -1.0,1.0);
            basketPosition = Range.clip(tiltPosition,-1.0,1.0);

            if (basketPosition > 0.5 && currentbasketPosition < 180) {
                currentbasketPosition = currentbasketPosition + 0.01;
                S1_Basket.setPosition(currentbasketPosition);

            }
            else if (basketPosition < -0.5 && currentbasketPosition > 0) {
                currentbasketPosition = currentbasketPosition - 0.01;
                S1_Basket.setPosition(currentbasketPosition);

            }


            M1_BLW.setPower(leftPower);
            M2_BRW.setPower(rightPower);
            M4_Arm.setPower(armPower);

            if (forwardSweeperPower == true) {
                M3_FLS.setPower(1.0);
            }
            else {
                M3_FLS.setPower(0.0);
            }

            if (backwardSweeperPower == true) {
                M3_FLS.setPower(-1.0);
            }
            else {
                M3_FLS.setPower(0.0);
            }


            telemetry.addData("Status", "Finished");
            telemetry.update();
        }
    }

}

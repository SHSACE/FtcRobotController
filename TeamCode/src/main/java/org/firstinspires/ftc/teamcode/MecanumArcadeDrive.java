package org.firstinspires.ftc.teamcode.drivetrainoptions;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mechanisms.Drone;
import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Slides;
import org.firstinspires.ftc.teamcode.mechanisms.Spatula;



@TeleOp
public class MecanumArcadeDrive extends LinearOpMode {
    private double slideFineAdjust = 0; //use 1 for servo ramp testing
    private int setLine = 0;
    private double TA = 0;
    private double drivemode = 0;
    double servotest = 0;

    ElapsedTime timer = new ElapsedTime();
    /*
        This function is where all of the drivetrain movement is.
        In specific the movement is like getting the joystick
        values and executing it to make it move in that direction
    */
    public void driveTrain(DcMotor frontLeftMotor, DcMotor backLeftMotor,
                           DcMotor frontRightMotor, DcMotor backRightMotor){
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;


//          Old reliable drive code
        if (drivemode==0){
            double demominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / demominator;
            double backLeftPower = (y - x + rx) / demominator;
            double frontRightPower = (y - x - rx) / demominator;
            double backRightPower = (y + x - rx) / demominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
        }




    }

    /* It checks the button press from the controller.
    It has a lot of if statements to check for the appropriate action from the controller.
    This function will have all of the mechanism modules called and use the functions from it. */
//    public void checkButtonPress(Slides slideLift, Intake intake, Spatula spatula, Drone drone){
//
//        if (gamepad2.dpad_down){  //break else so if driver controls intake and slides at the same time it can do more than one
//            intake.liftToLevel(0);
//        }
//        else if (gamepad2.dpad_left){   // Slides AND Intake lift, may change how intake lift happens. NEEDS testing my brain is dying
//            intake.liftToLevel(1);
//        }
//        else if (gamepad2.dpad_up){
//            intake.liftToLevel(2);
//        }
//        else if (gamepad2.dpad_right){
//            intake.liftToLevel(3);
//        }
//
//
//        if (gamepad2.right_trigger > 0.5) {  // Slot
//            spatula.slotForward();
//        } else if (gamepad2.right_bumper) {
//            spatula.slotReset();
//        }
//        //baby wheel controls
//        if (gamepad2.left_stick_y > 0.30) {
//            spatula.spinwheelBackwards();
//            spatula.spinBackWheelBackwards();
//        } else if (gamepad2.left_stick_y < -0.30) {
//            spatula.spinBothWheelsForward();
//        }
//        else if (gamepad2.left_stick_button) {
//            spatula.wheelCommands("stop");
//        }
////
//        if (gamepad2.y) {
//            intake.leftStackDown();
//        } else {
//            intake.leftStackUp();
//        }
//
//
//        if(gamepad2.x){
//            spatula.spinwheelBackwards();
//        }
//        else if(gamepad2.a){
//            spatula.spinBothWheelsBackward();
//        }
//
//        intake.spin(-gamepad2.left_stick_y-gamepad2.left_trigger);
//
//        if (gamepad2.right_stick_button) {
//            drone.shooter("open");
//        }





//        if (gamepad2.a) {
//            intake.kick(true);
//        } else {
//            intake.kick(false);
//        }

//        if (gamepad2.b) {
//            slideLift.overrideBound(true);
//        } else {
//            slideLift.overrideBound(false);
//        }
//
//
//        servotest += gamepad2.right_stick_x/1000; // use /1000 for servo ramp testing // Fine adjust for slide position for dropping pixels. Added to set line positons.,
//        slideLift.slideCommands(-gamepad2.right_stick_y);
//
//        if (gamepad2.left_bumper && intake.purplestate == Intake.PURPLE_STATE.CLOSED) {
//            intake.purplestate = Intake.PURPLE_STATE.DOWN;
//        } else if (intake.purplestate == Intake.PURPLE_STATE.READY){
//            intake.purplestate = Intake.PURPLE_STATE.UP;
//        }
//        intake.purpleArm(timer.seconds());
//
//
//        intake.leftStackPos(servotest);
//    }
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor frontLeftMotor = hardwareMap.get(DcMotor.class,"fl");
        DcMotor backLeftMotor = hardwareMap.get(DcMotor.class,"bl");
        DcMotor frontRightMotor = hardwareMap.get(DcMotor.class,"fr");
        DcMotor backRightMotor = hardwareMap.get(DcMotor.class,"br");
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

//        Slides slideLift = new Slides(hardwareMap);
//        Intake intake = new Intake(hardwareMap);
//        Spatula spatula  = new Spatula(hardwareMap);
//        Drone drone = new Drone(hardwareMap);
//
//        intake.liftToLevel(2);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            driveTrain(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
            //checkButtonPress(slideLift, intake, spatula, drone);

            //telemetry.addData("Purple State:", intake.purplestate);
            telemetry.addData("pos", servotest);
            telemetry.update();






        }

    }


}


// Uncomment 151-152 AND 111 AND 118
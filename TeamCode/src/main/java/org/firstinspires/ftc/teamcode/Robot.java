package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    /* Declare OpMode members. */
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;
    public DcMotor leadScrewMotor = null;
    public DcMotor extensionMotor = null;
    public CRServo intakeServo = null;
    public Servo wristServo = null;
    static final double MAX_DRIVE_SPEED = 1; //Is this too fast?
    static final double WRIST_UP_POSITION = 0.1;
    static final double WRIST_DOWN_POSITION = 0.2;


    public ElapsedTime runtime = new ElapsedTime();

    // Calculate the COUNTS_PER_INCH for your specific drive train.
    // Go to your motor vendor website to determine your motor's COUNTS_PER_MOTOR_REV
    // For external drive gearing, set DRIVE_GEAR_REDUCTION as needed.
    // For example, use a value of 2.0 for a 12-tooth spur gear driving a 24-tooth spur gear.
    // This is gearing DOWN for less speed and more torque.
    // For gearing UP, use a gear ratio less than 1.0. Note this will affect the direction of wheel rotation.
    static final double COUNTS_PER_MOTOR_REV = 537.7;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // No External Gearing.
    static final double DRIVE_WHEEL_DIAMETER_CENTIMETERS = 9.4;     // For figuring circumference
    static final double DRIVE_COUNTS_PER_CENTIMETERS = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (DRIVE_WHEEL_DIAMETER_CENTIMETERS * Math.PI);
    static final double DRIVE_WHEEL_BASE_CENTIMETERS = 4;
    static final double DRIVE_COUNTS_PER_DEGREE = (DRIVE_COUNTS_PER_CENTIMETERS * DRIVE_WHEEL_BASE_CENTIMETERS * Math.PI)/360.0;
    static final double LEAD_SCREW_COUNTS_PER_MOTOR_REV = 145.1;
    static final double LEAD_SCREW_DRIVE_GEAR_REDUCTION = 14/28;  //0.48148148148
    static final double LEAD_SCREW_DIAMETER_CENTIMETERS = 0.87;
    static final double LEAD_SCREW_COUNTS_PER_CENTIMETERS = (LEAD_SCREW_COUNTS_PER_MOTOR_REV * LEAD_SCREW_DRIVE_GEAR_REDUCTION)/ (LEAD_SCREW_DIAMETER_CENTIMETERS * Math.PI);
    static final double LINEAR_SLIDE_COUNTS_PER_MOTOR_REV = (2786.2);
    static final double LINEAR_SLIDE_DIAMETER_CENTIMETERS = (4);
    static final double LINEAR_SLIDE_GEAR_REDUCTION = (1);
    static final double LINEAR_SLIDE_COUNTS_PER_CENTIMETERS = (LINEAR_SLIDE_COUNTS_PER_MOTOR_REV * LINEAR_SLIDE_GEAR_REDUCTION) / (LINEAR_SLIDE_DIAMETER_CENTIMETERS * Math.PI);

    public HardwareMap hardwareMap;

    public void init(HardwareMap hardwareMap) {
        hardwareMap = hardwareMap;

        // Initialize the drive system variables.
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");

        leadScrewMotor = hardwareMap.get(DcMotor.class, "scissor_drive");
        extensionMotor = hardwareMap.get(DcMotor.class, "extension_drive");
        intakeServo = hardwareMap.get(CRServo.class, "intake");
        wristServo = hardwareMap.get(Servo.class, "wrist");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);
        leadScrewMotor.setDirection(DcMotor.Direction.FORWARD);
        leadScrewMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        extensionMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        leftFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    // move forward / backward function
    public void drive(double distanceCm, double power) {
        int leftFrontTargetPosition = leftFrontDrive.getCurrentPosition() - (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);
        int leftBackTargetPosition = leftBackDrive.getCurrentPosition() - (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);
        int rightFrontTargetPosition = rightFrontDrive.getCurrentPosition() - (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);
        int rightBackTargetPosition = rightBackDrive.getCurrentPosition() - (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);

        leftFrontDrive.setTargetPosition(leftFrontTargetPosition);
        leftBackDrive.setTargetPosition(leftBackTargetPosition);
        rightFrontDrive.setTargetPosition(rightFrontTargetPosition);
        rightBackDrive.setTargetPosition(rightBackTargetPosition);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFrontDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        leftBackDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        rightFrontDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        rightBackDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);


        while (leftFrontDrive.isBusy() && leftBackDrive.isBusy() && rightFrontDrive.isBusy() && rightBackDrive.isBusy()) {
        }

        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);
    }

    public void driveBackward(double distanceCm, double power) {
        double backwardsDistance = (Math.abs(distanceCm));
        drive(backwardsDistance, power);
    }

    public void driveForward(double distanceCm, double power) {
        double forwardsDistance = -(Math.abs(distanceCm));
        drive(forwardsDistance, power);
    }

    public void strafe(double distanceCm, double power) {
        int leftFrontTargetPosition = leftFrontDrive.getCurrentPosition() + (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);
        int leftBackTargetPosition = leftBackDrive.getCurrentPosition() - (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);
        int rightFrontTargetPosition = rightFrontDrive.getCurrentPosition() - (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);
        int rightBackTargetPosition = rightBackDrive.getCurrentPosition() + (int) (distanceCm * DRIVE_COUNTS_PER_CENTIMETERS);

        leftFrontDrive.setTargetPosition(leftFrontTargetPosition);
        leftBackDrive.setTargetPosition(leftBackTargetPosition);
        rightFrontDrive.setTargetPosition(rightFrontTargetPosition);
        rightBackDrive.setTargetPosition(rightBackTargetPosition);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFrontDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        leftBackDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        rightFrontDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        rightBackDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);

        while (leftFrontDrive.isBusy() && leftBackDrive.isBusy() && rightFrontDrive.isBusy() && rightBackDrive.isBusy()) {
        }

        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);

    }

    public void strafeRight(double distanceCm, double power) {
        double strafeRightDistance = (Math.abs(distanceCm));
        strafe(strafeRightDistance, power);
    }

    public void strafeLeft(double distanceCm, double power) {
        double strafeLeftDistance = -(Math.abs(distanceCm));
        strafe(strafeLeftDistance, power);
    }
    public void spin(double degrees, double power) {
        int leftFrontTargetPosition = leftFrontDrive.getCurrentPosition() + (int) (degrees * DRIVE_COUNTS_PER_DEGREE);
        int leftBackTargetPosition = leftBackDrive.getCurrentPosition() + (int) (degrees * DRIVE_COUNTS_PER_DEGREE);
        int rightFrontTargetPosition = rightFrontDrive.getCurrentPosition() - (int) (degrees * DRIVE_COUNTS_PER_DEGREE);
        int rightBackTargetPosition = rightBackDrive.getCurrentPosition() - (int) (degrees * DRIVE_COUNTS_PER_DEGREE);

        leftFrontDrive.setTargetPosition(leftFrontTargetPosition);
        leftBackDrive.setTargetPosition(leftBackTargetPosition);
        rightFrontDrive.setTargetPosition(rightFrontTargetPosition);
        rightBackDrive.setTargetPosition(rightBackTargetPosition);

        leftFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFrontDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBackDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFrontDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        leftBackDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        rightFrontDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);
        rightBackDrive.setPower(Math.abs(power) * MAX_DRIVE_SPEED);


        while (leftFrontDrive.isBusy() && leftBackDrive.isBusy() && rightFrontDrive.isBusy() && rightBackDrive.isBusy()) {
        }

        leftFrontDrive.setPower(0);
        leftBackDrive.setPower(0);
        rightFrontDrive.setPower(0);
        rightBackDrive.setPower(0);

    }

    public void spinCounterClockwise(double degrees, double power) {
        double pivotLeftDistance = (Math.abs(degrees));
        strafe(pivotLeftDistance, power);
    }

    public void spinClockwise(double degrees, double power) {
        double pivotRightDistance = -(Math.abs(degrees));
        spin(pivotRightDistance,power);
    }

//    public void wristUp() {
//        wristServo.setPosition(WRIST_UP_POSITION);
//    }
//
//    public void wristDown(){
//        wristServo.setPosition(WRIST_DOWN_POSITION);
//    }

    public void extendScissorLift (double power){
        leadScrewMotor.setPower(Math.abs(power));
    }

    public void retractScissorLift(double power) {
        leadScrewMotor.setPower(-(Math.abs(power)));

    }
    public void extendLinearSlide (double power){
        extensionMotor.setPower(Math.abs(power));
        }

    public void retractLinearSlide(double power) {
        extensionMotor.setPower(-(Math.abs(power)));
    }

        public void intake (double power){
            intakeServo.setPower(Math.abs(power));
        }

        public void outtake ( double power){
            intakeServo.setPower(-(Math.abs(power)));
        }

        public void scissor ( double distanceCm, double power){
            int leadScrewTargetPosition = leadScrewMotor.getCurrentPosition() + (int) (distanceCm * LEAD_SCREW_COUNTS_PER_CENTIMETERS);

            leadScrewMotor.setTargetPosition(leadScrewTargetPosition);

            leadScrewMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            leadScrewMotor.setPower(Math.abs(power) * 0.6);

            while (leadScrewMotor.isBusy()) {
            }
            leadScrewMotor.setPower(0);
        }

        public void linearSlide ( double distanceCm, double power){
            int linearSlideTargetPosition = extensionMotor.getCurrentPosition() + (int) (distanceCm * LINEAR_SLIDE_COUNTS_PER_CENTIMETERS);

            extensionMotor.setTargetPosition(linearSlideTargetPosition);

            extensionMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            extensionMotor.setPower(Math.abs(power) * 0.6);

            while (extensionMotor.isBusy()) {
            }
            extensionMotor.setPower(0);
        }


    }
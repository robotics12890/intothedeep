package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    /* Declare OpMode members. */
    public DcMotor leftFrontDrive = null;
    public DcMotor leftBackDrive = null;
    public DcMotor rightFrontDrive = null;
    public DcMotor rightBackDrive = null;
    static final double MAX_DRIVE_SPEED = 1;

    public ElapsedTime runtime = new ElapsedTime();

    // Calculate the COUNTS_PER_INCH for your specific drive train.
    // Go to your motor vendor website to determine your motor's COUNTS_PER_MOTOR_REV
    // For external drive gearing, set DRIVE_GEAR_REDUCTION as needed.
    // For example, use a value of 2.0 for a 12-tooth spur gear driving a 24-tooth spur gear.
    // This is gearing DOWN for less speed and more torque.
    // For gearing UP, use a gear ratio less than 1.0. Note this will affect the direction of wheel rotation.
    static final double COUNTS_PER_MOTOR_REV = 537.7;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // No External Gearing.
    static final double DRIVE_WHEEL_DIAMETER_CENTIMETERS = 9.6;     // For figuring circumference
    static final double DRIVE_COUNTS_PER_CENTIMETERS = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (DRIVE_WHEEL_DIAMETER_CENTIMETERS * 3.1415);
    static final double DRIVE_WHEEL_BASE_CENTIMETERS = 4;
    static final double DRIVE_COUNTS_PER_DEGREE = (DRIVE_COUNTS_PER_CENTIMETERS * DRIVE_WHEEL_BASE_CENTIMETERS * 3.1415)/360.0;

    public HardwareMap hardwareMap;

    public void init(HardwareMap hardwareMap) {
        hardwareMap = hardwareMap;

        // Initialize the drive system variables.
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive = hardwareMap.get(DcMotor.class, "right_back_drive");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

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
    public void pivot(double degrees, double power) {
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

    public void pivotLeft (double degrees, double power) {
        double pivotLeftDistance = (Math.abs(degrees));
        strafe(pivotLeftDistance, power);
    }

    public void pivotRight (double degrees, double power) {
        double pivotRightDistance = -(Math.abs(degrees));
        pivot(pivotRightDistance,power);
    }
}


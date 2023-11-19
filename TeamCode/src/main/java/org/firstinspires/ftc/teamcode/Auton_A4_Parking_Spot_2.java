package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auton A4 Spot 2", group = "Robot")
public class Auton_A4_Parking_Spot_2 extends LinearOpMode {
    /* Declare OpMode members. */
    Robot robot = new Robot();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Starting at", "%7d :%7d :%7d :%7d",
                robot.leftFrontDrive.getCurrentPosition(),
                robot.rightFrontDrive.getCurrentPosition(),
                robot.leftBackDrive.getCurrentPosition(),
                robot.rightBackDrive.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //algorithm
        robot.driveForward(75,robot.MAX_DRIVE_SPEED);
        robot.driveBackward(70,robot.MAX_DRIVE_SPEED);
        robot.strafeLeft(121, robot.MAX_DRIVE_SPEED);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);  // pause to display final telemetry message.
    }
}


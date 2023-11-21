package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auton F4 Spot 2 v1", group = "Robot")

public class Auton_F4_Parking_Spot_2
        extends LinearOpMode {
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
        robot.driveForward(75, robot.MAX_DRIVE_SPEED);
        robot.driveBackward(30.5, robot.MAX_DRIVE_SPEED);
        robot.strafeLeft(61, robot.MAX_DRIVE_SPEED);
        robot.driveForward(84, robot.MAX_DRIVE_SPEED);
        robot.strafeLeft(61, robot.MAX_DRIVE_SPEED);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);  // pause to display final telemetry message.
    }
}




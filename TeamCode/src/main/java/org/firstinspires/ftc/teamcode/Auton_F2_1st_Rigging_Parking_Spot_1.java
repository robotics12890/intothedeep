package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/*
 * This OpMode illustrates the concept of driving a path based on encoder counts.
 * The code is structured as a LinearOpMode
 *
 * The code REQUIRES that you DO have encoders on the wheels,
 *   otherwise you would use: RobotAutoDriveByTime;
 *
 *  This code ALSO requires that the drive Motors have been configured such that a positive
 *  power command moves them forward, and causes the encoders to count UP.
 *
 *   The desired path in this example is:
 *   - Drive forward for 48 inches
 *   - Spin right for 12 Inches
 *   - Drive Backward for 24 inches
 *   - Stop and close the claw.
 *
 *  The code is written using a method called: encoderDrive(speed, leftInches, rightInches, timeoutS)
 *  that performs the actual movement.
 *  This method assumes that each movement is relative to the last stopping place.
 *  There are other ways to perform encoder based moves, but this method is probably the simplest.
 *  This code uses the RUN_TO_POSITION mode to enable the Motor controllers to generate the run profile
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */
@Autonomous(name = "Auton F2 1st Rigging Spot 1 v14", group = "Robot")
public class Auton_F2_1st_Rigging_Parking_Spot_1 extends LinearOpMode{

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
            robot.driveBackward(67,robot.MAX_DRIVE_SPEED);
            robot.openClaw();
            robot.autonElevate(-21,robot.MAX_DRIVE_SPEED);
            robot.completelyOpenClaw();
            robot.strafeRight(264,robot.MAX_DRIVE_SPEED);
//            robot.turnRight(61,0.5);
//            robot.driveForward (264, 0.5);

            telemetry.addData("Path", "Complete");
            telemetry.update();
            sleep(1000);  // pause to display final telemetry message.
        }
    }

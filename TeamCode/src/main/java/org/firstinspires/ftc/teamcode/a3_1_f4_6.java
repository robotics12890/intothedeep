package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "a3/f4 to a1/f6 v6", group = "Robot")
public class a3_1_f4_6 extends LinearOpMode {
    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        robot.wristNeutral();
        waitForStart();

        robot.driveForward(20,0.5);
        robot.strafeLeft(190,0.5);
        robot.strafeRight(190,0.5);
        robot.strafeRight(90, 0.5);
        robot.driveBackward(15,0.5);
        // this goes from a3/f4 to f1/a6 then f6/a1 by strafing after driving slightly forward to avoid scraping the wall.
        //2 tiles
    }
}
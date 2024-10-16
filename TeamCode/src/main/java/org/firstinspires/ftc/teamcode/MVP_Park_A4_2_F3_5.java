package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "MVP Part A4/F3 to A2/F5 v1")
public class MVP_Park_A4_2_F3_5 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode(){
        robot.init(hardwareMap);
        waitForStart();

        robot.driveForward(7,1);
        robot.strafeRight(120,1);
        //strafes from a4/f3 to a2/f5 after driving slightly forward to avoid scraping the wall.
        // 2 tiles
    }
}

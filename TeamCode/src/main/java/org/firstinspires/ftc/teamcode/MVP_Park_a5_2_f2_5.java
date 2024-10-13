package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "MVP Park A5/F2 to A2/F5 v1", group = "Robot")
public class MVP_Park_a5_2_f2_5 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        robot.driveForward(7,1);
        robot.strafeRight(180,1);
        //This strafes from a5/f2 to a2/f5 after driving slightly forward to avoid scraping the wall.
        //3 tiles
    }
}

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Park A4/F3 to A1/F6", group = "Robot")
public class MVP_Park_A3_1_F3_6_Auto extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode(){
        robot.init(hardwareMap);
        waitForStart();
        robot.strafe(180,1);
        //this starts in a3/f3 and strafes in a1/f6
        //3 tiles
    }
}

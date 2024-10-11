package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "MVP Part A4/F3 to A2/F5")
public class MVP_Park_A4_2_F3_5 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode(){
        robot.init(hardwareMap);
        waitForStart();

        robot.strafeRight(120,1);
        //assign distance for two tiles
    }
}

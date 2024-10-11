package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "MVP Park A5/F2 to A2/F5", group = "Robot")
public class MVP_Park_a5_2_f2_5 extends LinearOpMode {

    Robot robot = new Robot();

    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();

        robot.strafeRight(180,1);
        // assign distance for 3 tiles
    }
}

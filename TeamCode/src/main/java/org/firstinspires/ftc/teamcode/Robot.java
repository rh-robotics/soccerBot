package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.springframework.statemachine.StateMachine;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final StateMachine stateMachine;
    private final OpMode opMode;
    private final List<SubSystem> subSystems;
    public Robot(StateMachine sm, OpMode om) {
        stateMachine = sm;
        opMode = om;
        subSystems = new ArrayList<>();
    }

    public void addSubSystem(SubSystem s) {
        subSystems.add(s);
    }

    public void controllerUpdate(Gamepad previous, Gamepad current) {

    }
}

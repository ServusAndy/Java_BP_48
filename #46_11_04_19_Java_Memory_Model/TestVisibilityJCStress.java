package com.sheygam.tests;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.II_Result;

import static org.openjdk.jcstress.annotations.Expect.*;


@Outcome(id = "0, 0", expect = ACCEPTABLE, desc = "Doing both reads early.")
@Outcome(id = "1, 1", expect = ACCEPTABLE, desc = "Doing both reads late.")
@Outcome(id = "0, 1", expect = ACCEPTABLE, desc = "Caught in the middle: $x is visible, $y is not.")
@Outcome(id = "1, 0", expect = ACCEPTABLE_INTERESTING, desc = "Seeing $y, but not $x!")
@State
@JCStressTest
public class TestVisibilityJCStress {
    int x;
    /*volatile*/ int y;

    @Actor
    public void actor1() {
        x = 1;
        y = 1;
    }

    @Actor
    public void actor2(II_Result r) {
        r.r1 = y;
        r.r2 = x;
    }
}

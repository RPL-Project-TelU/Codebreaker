package model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pacmanlogic.*;
import java.util.Arrays;
import org.junit.Test;

public class Submission {
    @Test
    public void Submission() {
        Submission l = new Submission();
        p.losesubmission();
        assertEquals("submission", 2, p.getSubmission());
    }
}

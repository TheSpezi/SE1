package org.hbrs.se1.ws25.exercises.uebung2;

import java.util.List;

public class MemberView {

    public void dump(List<Member> liste){
        for(Member m : liste){
            System.out.println(m);
        }
    }
}

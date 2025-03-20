package com.chris.model;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static List<Term> getAllTerms() {
        Session session = new Session();
        session.setSessionId(1);
        session.setSessionYear("2025/2026");

        // All terms
        ArrayList<Term> terms = new ArrayList<>();
        // First term and fee
        Fee firstTermFee = new Fee();
        firstTermFee.setFeeId(1);
        firstTermFee.setAmount(40000.00);

        Term firstTerm = new Term();
        firstTerm.setTermId(1);
        firstTerm.setTermType("1ST TERM");
        firstTerm.setSession(session);
        // linking fee and term
        firstTerm.setFee(firstTermFee);
        firstTermFee.setTerm(firstTerm);

        // second term and fee
        Fee secondTermFee = new Fee();
        secondTermFee.setFeeId(2);
        secondTermFee.setAmount(45000.00);

        Term secondTerm = new Term();
        secondTerm.setTermId(2);
        secondTerm.setTermType("2ND TERM");
        secondTerm.setSession(session);
        // linking fee and term
        secondTerm.setFee(secondTermFee);
        secondTermFee.setTerm(secondTerm);

        // Third term and fee
        Fee thirdTermFee = new Fee();
        thirdTermFee.setFeeId(3);
        thirdTermFee.setAmount(50000.00);

        Term thirdTerm = new Term();
        thirdTerm.setTermId(3);
        thirdTerm.setTermType("3RD TERM");
        thirdTerm.setSession(session);
        // linking fee and term
        thirdTerm.setFee(thirdTermFee);
        thirdTermFee.setTerm(thirdTerm);

        terms.add(firstTerm);
        terms.add(secondTerm);
        terms.add(thirdTerm);

        return terms;
    }

}

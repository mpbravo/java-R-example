package com.jboss.examples.brms;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class RExecutionTest {
	
	public static void main(String[] args) {
		System.out.println("Testing R code in Java");
		System.out.println(evaluate());
	}

	private static String evaluate(){
		Rengine r = new Rengine(new String[]{"--no-save"}, false, null);
		System.out.println("Rengine created, waiting for R");
		 
        // the engine creates R is a new thread, so we should wait until it's
        // ready
        if (!r.waitForR()) {
            System.out.println("Cannot load R");
            return null;
        }
	    r.eval("library(Hmisc)");
	    r.eval("yy <- describe(rnorm(200))");
	    REXP exp = r.eval("zz <- yy$counts[5:11]");
	    REXP names = r.eval("names(zz)");
	    String[] strExp = exp.asStringArray();
	    System.out.println("result:" + exp);
	 
	    r.eval("histval <- hist(rnorm(100), plot=FALSE)");
	    REXP xvalExp = r.eval("histval$mids");
	    REXP yvalExp = r.eval("histval$counts");
	    
	    return ("histval$mids:" + xvalExp + " histval$counts:" + yvalExp);
	}
}

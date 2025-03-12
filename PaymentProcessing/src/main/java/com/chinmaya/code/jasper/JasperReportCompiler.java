package com.chinmaya.code.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;

public class JasperReportCompiler {
    public static void main(String[] args) throws JRException {
        JasperCompileManager.compileReportToFile(
                "src/main/resources/reports/sample-report.jrxml",
                "src/main/resources/reports/sample-report.jasper");
    }
}

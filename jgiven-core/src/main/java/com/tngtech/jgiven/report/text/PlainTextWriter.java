package com.tngtech.jgiven.report.text;

import java.io.PrintStream;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Attribute;
import org.fusesource.jansi.Ansi.Color;

import com.tngtech.jgiven.report.model.ReportModelVisitor;

public class PlainTextWriter extends ReportModelVisitor {
    protected final PrintStream stream;
    protected final boolean withColor;

    public PlainTextWriter( PrintStream stream, boolean withColor ) {
        this.stream = stream;
        this.withColor = withColor;
    }

    void println( Color color, String text ) {
        stream.println( withColor( color, text ) );
    }

    String withColor( Color color, String text ) {
        return withColor( color, false, null, text );
    }

    String withColor( Color color, Attribute attribute, String text ) {
        return withColor( color, false, attribute, text );
    }

    String withColor( Color color, boolean bright, Attribute attribute, String text ) {
        if( withColor ) {
            Ansi ansi = bright ? Ansi.ansi().fgBright( color ) : Ansi.ansi().fg( color );
            if( attribute != null ) {
                ansi = ansi.a( attribute );
            }
            return ansi.a( text ).reset().toString();
        }
        return text;
    }
}
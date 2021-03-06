// ----------------------
// SingletonPatternT.java
// ----------------------

// https://en.wikipedia.org/wiki/Singleton_pattern

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

@SuppressWarnings("auxiliaryclass")
public final class SingletonPatternT extends TestCase {
    public void test_1 () {
    	assertEquals(Eager.only(), Eager.only());}

    public void test_2 () {
    	assertEquals(Eager.only().f(), "Eager.f()");}

    public void test_3 () {
    	assertEquals(Lazy.only(), Lazy.only());}

    public void test_4 () {
    	assertEquals(Lazy.only().f(), "Lazy.f()");}

    public static void main (String[] args) {
        System.out.println("SingletonPatternT.java");
        TestRunner.run(new TestSuite(SingletonPatternT.class));
        System.out.println("Done.");}}

/*
% javac -X
  -Xlint                     Enable recommended warnings
  -Xlint:{all,auxiliaryclass,cast,classfile,deprecation,dep-ann,divzero,
  empty,fallthrough,finally,options,overloads,overrides,path,processing,
  rawtypes,serial,static,try,unchecked,varargs,-auxiliaryclass,-cast,-
  classfile,-deprecation,-dep-ann,-divzero,-empty,-fallthrough,-finally,
  -options,-overloads,-overrides,-path,-processing,-rawtypes,-serial,-
  static,-try,-unchecked,-varargs,none} Enable or disable specific
  warnings -Xdoclint                  Enable recommended checks for
  problems in javadoc comments
  -Xdoclint:(all|none|[-]<group>)[/<access>] Enable or disable specific
  checks for problems in javadoc comments, where <group> is one of
  accessibility, html, missing, reference, or syntax, and <access> is
  one of public, protected, package, or private.
  -Xbootclasspath/p:<path>   Prepend to the bootstrap class path
  -Xbootclasspath/a:<path>   Append to the bootstrap class path
  -Xbootclasspath:<path>     Override location of bootstrap class files
  -Djava.ext.dirs=<dirs>     Override location of installed extensions
  -Djava.endorsed.dirs=<dirs> Override location of endorsed standards
  path -Xmaxerrs <number>         Set the maximum number of errors to
  print -Xmaxwarns <number>        Set the maximum number of warnings to
  print -Xstdout <filename>        Redirect standard output -Xprint
                Print out a textual representation of specified types
  -XprintRounds              Print information about rounds of
  annotation processing -XprintProcessorInfo       Print information
  about which annotations a processor is asked to process
  -Xprefer:{source,newer}    Specify which file to read when both a
  source file and class file are found for an implicitly compiled class
  -Xpkginfo:{always,legacy,nonempty} Specify handling of package-info
  files -Xplugin:"name args"       Name and optional arguments for a
  plug-in to be run -Xdiags:{compact,verbose}  Select a diagnostic mode

These options are non-standard and subject to change without notice.
*/

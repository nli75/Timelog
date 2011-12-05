package se.timelog.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Page {

	public abstract void doStuff(List<String> remainingPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}

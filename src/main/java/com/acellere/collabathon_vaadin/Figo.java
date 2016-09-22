package com.acellere.collabathon_vaadin;

import me.figo.FigoSession;

public class Figo {
	private static FigoSession session;

	public static FigoSession getSession() {
		if (session == null)
			session = new FigoSession(
					"ASHWLIkouP2O6_bgA2wWReRhletgWKHYjLqDaqb0LFfamim9RjexTo22ujRIP_cjLiRiSyQXyt2kM1eXU2XLFZQ0Hro15HikJQT_eNeT_9XQ");
		return session;
	}
}

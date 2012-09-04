package org.miernik.refreshtableview;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNumberOfChangesProperty() {
		final Person p = new Person("A", "B");
		
		assertEquals(0, p.numberOfChangesProperty().get());
		p.setFirstName("A2");
		assertEquals(1, p.numberOfChangesProperty().get());
	}

}

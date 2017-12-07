package roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class DaijiTest {
/*
	@Test
	public void test_to_number() {
		Daiji daiji = new Daiji();
		assertEquals(0 , daiji.to_number("零"));
		assertEquals(1 , daiji.to_number("壱"));
		assertEquals(10 , daiji.to_number("拾"));
		assertEquals(20 , daiji.to_number("弐拾"));
		assertEquals(39 , daiji.to_number("参拾玖"));
		assertEquals(1000 , daiji.to_number("仟"));
		assertEquals(4000 , daiji.to_number("肆仟"));
		assertEquals(9465 , daiji.to_number("玖仟肆佰陸拾伍"));
	}
*/
	@Test
	public void test_to_daiji() {
		Daiji daiji = new Daiji();
		assertEquals("零",daiji.to_daiji(0));
		assertEquals("壱",daiji.to_daiji(1));
		assertEquals("拾",daiji.to_daiji(10));
		assertEquals("弐拾",daiji.to_daiji(20));
		assertEquals("参拾玖",daiji.to_daiji(39));
		assertEquals("仟",daiji.to_daiji(1000));
		assertEquals("肆仟",daiji.to_daiji(4000));
		assertEquals("玖仟肆佰陸拾伍",daiji.to_daiji(9465));
	}

}

package org.homa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Timecontainer {

	LocalDateTime localDateTime;
	LocalDate localDate;

	String teststring = "    this is a teststring that has some whitespace at the beginning and the end    ";
}

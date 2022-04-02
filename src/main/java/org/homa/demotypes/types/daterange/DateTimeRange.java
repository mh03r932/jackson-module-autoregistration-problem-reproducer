/*
 * Copyright (C) 2022 DV Bern AG, Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.homa.demotypes.types.daterange;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.checkerframework.checker.nullness.qual.NonNull;

@Embeddable
public class DateTimeRange implements Serializable {

	private static final long serialVersionUID = -2321415284318466343L;

	@NotNull @NonNull
	@Column(nullable = false)
	private LocalDateTime von;

	@NotNull @NonNull
	@Column(nullable = false)
	private LocalDateTime bis;

	/**
	 * Only makes sense when used by JPA!.
	 */
	protected DateTimeRange() {
		von = LocalDateTime.now();
		bis = LocalDateTime.now();
	}

	protected DateTimeRange(LocalDateTime von, LocalDateTime bis) {
		this.von = von;
		this.bis = bis;
	}

	public static DateTimeRange of(LocalDateTime von, LocalDateTime bis) {
		return new DateTimeRange(von, bis);
	}

	public static DateTimeRange of(DateTimeRange other) {
		return new DateTimeRange(other.getVon(), other.getBis());
	}

	/**
	 * von <= time <= bis
	 */
	public boolean isInRange(LocalDateTime time) {
		return !(time.isBefore(getVon()) || time.isAfter(getBis()));
	}

	public boolean hasValidRange() {
		return !getVon().isAfter(getBis());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof DateTimeRange)) {
			return false;
		}

		DateTimeRange timeRange = (DateTimeRange) o;

		if (!getVon().equals(timeRange.getVon())) {
			return false;
		}

		return getBis().equals(timeRange.getBis());

	}

	@Override
	//CSOFF: MagicNumberCheck
	public int hashCode() {
		int result = getVon().hashCode();
		result = 31 * result + getBis().hashCode();

		return result;
	}

	@NonNull
	public LocalDateTime getVon() {
		return von;
	}

	public void setVon(@NonNull LocalDateTime von) {
		this.von = von;
	}

	@NonNull
	public LocalDateTime getBis() {
		return bis;
	}

	public void setBis(@NonNull LocalDateTime bis) {
		this.bis = bis;
	}
}

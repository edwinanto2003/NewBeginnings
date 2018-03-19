package com.edwin.ether;

import java.util.Date;

public class Ether
{
	final double open;

	final double close;

	final double weightedAvg;

	final double volume;

	final Date date;

	public Ether(EtherBuilder builder)
	{
		this.open = builder.open;
		this.close = builder.close;
		this.weightedAvg = builder.weightedAvg;
		this.volume = builder.volume;
		this.date = builder.date;
	}

	/**
	 * @return the open
	 */
	public double getOpen()
	{
		return open;
	}

	/**
	 * @return the close
	 */
	public double getClose()
	{
		return close;
	}

	/**
	 * @return the weightedAvg
	 */
	public double getWeightedAvg()
	{
		return weightedAvg;
	}

	/**
	 * @return the volume
	 */
	public double getVolume()
	{
		return volume;
	}

	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	public static final class EtherBuilder
	{
		double open;

		double close;

		double weightedAvg;

		double volume;

		Date date;

		public static EtherBuilder create()
		{
			return new EtherBuilder();
		}

		/**
		 * @param open the open to set
		 */
		public EtherBuilder setOpen(double open)
		{
			this.open = open;
			return this;
		}

		/**
		 * @param close the close to set
		 */
		public EtherBuilder setClose(double close)
		{
			this.close = close;
			return this;
		}

		/**
		 * @param weightedAvg the weightedAvg to set
		 */
		public EtherBuilder setWeightedAvg(double weightedAvg)
		{
			this.weightedAvg = weightedAvg;
			return this;
		}

		/**
		 * @param volume the volume to set
		 */
		public EtherBuilder setVolume(double volume)
		{
			this.volume = volume;
			return this;
		}

		/**
		 * @param date the date to set
		 */
		public EtherBuilder setDate(Date date)
		{
			this.date = date;
			return this;
		}
	}
}

package com.date.simpledateformatter.ex1;

import java.text.DateFormat;

import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

public class SimpleDateFormatThreadLocal {

	private ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {

		@Override
		public DateFormat get() {

			return super.get();

		}

		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("yyyy-MM-dd");

		}

		@Override
		public void remove() {

			super.remove();

		}

		@Override
		public void set(DateFormat value) {

			super.set(value);

		}

	};

	public Date convertStringToDate(Date dateString) throws ParseException {

		return df.get().parse(df.get().format(dateString));

	}

}
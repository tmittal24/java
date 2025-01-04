package com.yogi.persist.serialization.ex3;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class DocumentDescription implements Serializable {
	// private InputStream _actualDocument;
	// while adding serialization make this field transient. so modify above
	// line
	// and make this class implements serializable
	private InputStream _actualDocument;

	private int _length;

	private int _documentType;

	private boolean _printTwoSided;

	private int _printQuality;

	public DocumentDescription(InputStream actualDocument) throws IOException {
		this(actualDocument, 0, true, 1);
	}

	public DocumentDescription(InputStream actualDocument, int documentType, boolean printTwoSided, int printQuality) throws IOException {
		_documentType = documentType;
		_printTwoSided = printTwoSided;
		_printQuality = printQuality;
		BufferedInputStream buffer = new BufferedInputStream(actualDocument);
		DataInputStream dataInputStream = new DataInputStream(buffer);
		ByteArrayOutputStream temporaryBuffer = new ByteArrayOutputStream();
		_length = copy(dataInputStream, new DataOutputStream(temporaryBuffer));
		_actualDocument = new DataInputStream(new ByteArrayInputStream(temporaryBuffer.toByteArray()));
	}

	public int getDocumentType() {
		return _documentType;
	}

	public boolean isPrintTwoSided() {
		return _printTwoSided;
	}

	public int getPrintQuality() {
		return _printQuality;
	}

	private int copy(InputStream source, OutputStream destination) throws IOException {
		int nextByte;
		int numberOfBytesCopied = 0;
		while (-1 != (nextByte = source.read())) {
			destination.write(nextByte);
			numberOfBytesCopied++;
		}
		destination.flush();
		return numberOfBytesCopied;
	}

	// ////////// methods added later for serialization
	/**
	 * There is also an order dependency here. The first value written must be
	 * the first value read. Since we start writing by calling
	 * defaultWriteObject( ), we have to start reading by calling default-
	 * ReadObject( ). On the bright side, this means we'll have an accurate
	 * value for _lengthbefore we try to read _actualDocumentfrom the stream.*
	 */
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		copy(_actualDocument, out);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		ByteArrayOutputStream temporaryBuffer = new ByteArrayOutputStream();
		copy(in, temporaryBuffer, _length);
		_actualDocument = new DataInputStream(new ByteArrayInputStream(temporaryBuffer.toByteArray()));
	}

	private void copy(InputStream source, OutputStream destination, int length) throws IOException {
		int counter;
		int nextByte;
		for (counter = 0; counter < length; counter++) {
			nextByte = source.read();
			destination.write(nextByte);
		}
		destination.flush();
	}

}
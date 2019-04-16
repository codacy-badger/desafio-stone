package com.barros.desafiostone.util.serialize;

import java.io.IOException;
import java.math.BigDecimal;

import com.barros.desafiostone.exception.InputDataException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class MoneyDeserializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		if (parser.hasToken(JsonToken.VALUE_STRING)) {
			String stringInput = parser.getText().trim();
			if (stringInput.length() == 0) {
				return null;
			} else {
				return parseToBigDecimal(stringInput);
			}
		}

		return null;
	}

	private BigDecimal parseToBigDecimal(String input) throws InputDataException {
		String regexOne = "\\d+";
		String regexTwo = "\\d+.\\d+";

		if (input.startsWith("R$")) {
			String moneyValue = input.replaceAll("\\s", "");

			String numberValue = moneyValue.split("\\$")[1];

			numberValue = numberValue.replaceAll("\\.", "");

			numberValue = numberValue.replaceAll(",", "\\.");

			return new BigDecimal(numberValue);
		} else if (input.matches(regexOne) || input.matches(regexTwo)) {
			return new BigDecimal(input);
		} else {
			throw new InputDataException("Dado inválido!");
		}

	}

}
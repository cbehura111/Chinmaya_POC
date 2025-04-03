package com.chinmaya.cache.payload.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LovData {

	String lovName;

	String lovId;

	String language;

}

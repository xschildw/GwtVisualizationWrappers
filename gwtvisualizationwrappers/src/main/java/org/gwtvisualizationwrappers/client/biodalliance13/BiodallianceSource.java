package org.gwtvisualizationwrappers.client.biodalliance13;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;

/**
 * Source object represents a Biodalliance track source. 
 */
public class BiodallianceSource {
	String sourceName, sourceURI, entityId, indexEntityId, indexSourceURI;
	Long version, indexVersion;
	public static final String DEFAULT_STYLE_TYPE = "default";
	public static final String DEFAULT_STYLE_GLYPH_TYPE = "HISTOGRAM";
	public static final String DEFAULT_STYLE_COLOR = "#808080"; //grey
	public static final Integer DEFAULT_HEIGHT = 30;
	
	String styleType, styleGlyphType, styleColor;
	int heightPx;

	public enum SourceType {
		BIGWIG, VCF, BED
	}
	SourceType sourceType;
	
	/**
	 * json keys
	 */
	public static final String SOURCE_NAME_KEY = "name";
	public static final String SOURCE_TYPE = "type";
	public static final String SOURCE_ENTITY_ID_KEY = "entityId";
	public static final String SOURCE_ENTITY_VERSION_KEY = "entityVersion";
	public static final String SOURCE_INDEX_ENTITY_ID_KEY = "indexEntityId";
	public static final String SOURCE_INDEX_ENTITY_VERSION_KEY = "indexEntityVersion";
	public static final String STYLE_TYPE_KEY = "styleType";
	public static final String STYLE_GLYPH_TYPE_KEY = "styleGlyphType";
	public static final String STYLE_COLOR_KEY = "color";
	public static final String STYLE_HEIGHT = "height";
	
	public BiodallianceSource() {
		initDefaults();
	}
	
	public BiodallianceSource(String json) {
		initializeFromJson(json);
	}
	
	
	public void initDefaults() {
		styleType = DEFAULT_STYLE_TYPE;
		styleGlyphType = DEFAULT_STYLE_GLYPH_TYPE;
		styleColor = DEFAULT_STYLE_COLOR;
		heightPx = DEFAULT_HEIGHT;
	}
	
	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(SOURCE_NAME_KEY, new JSONString(sourceName));
		jsonObject.put(SOURCE_ENTITY_ID_KEY, new JSONString(entityId));
		if (version != null) {
			jsonObject.put(SOURCE_ENTITY_VERSION_KEY, new JSONString(version.toString()));	
		}
		if (indexEntityId != null) {
			jsonObject.put(SOURCE_INDEX_ENTITY_ID_KEY, new JSONString(indexEntityId));	
		}
		if (indexVersion != null) {
			jsonObject.put(SOURCE_INDEX_ENTITY_VERSION_KEY, new JSONString(indexVersion.toString()));	
		}
		jsonObject.put(STYLE_TYPE_KEY, new JSONString(styleType));
		jsonObject.put(STYLE_GLYPH_TYPE_KEY, new JSONString(styleGlyphType));
		jsonObject.put(STYLE_COLOR_KEY, new JSONString(styleColor));
		jsonObject.put(SOURCE_TYPE, new JSONString(sourceType.name()));
		jsonObject.put(STYLE_HEIGHT, new JSONString(Integer.toString(heightPx)));
		return jsonObject;
	}
	
	public void initializeFromJson(String json) {
		JSONObject value = (JSONObject)JSONParser.parseStrict(json);
		setSourceName(value.get(SOURCE_NAME_KEY).isString().stringValue());
		String entityId = value.get(SOURCE_ENTITY_ID_KEY).isString().stringValue();
		Long version = null;
		if (value.containsKey(SOURCE_ENTITY_VERSION_KEY)) {
			String versionString = value.get(SOURCE_ENTITY_VERSION_KEY).isString().stringValue();
			version = Long.parseLong(versionString);
		}
		setEntity(entityId, version);
		
		String indexEntityId = null;
		if (value.containsKey(SOURCE_INDEX_ENTITY_ID_KEY)) {
			indexEntityId = value.get(SOURCE_INDEX_ENTITY_ID_KEY).isString().stringValue();
		}
		Long indexVersion = null;
		if (value.containsKey(SOURCE_INDEX_ENTITY_VERSION_KEY)) {
			String versionString = value.get(SOURCE_INDEX_ENTITY_VERSION_KEY).isString().stringValue();
			indexVersion = Long.parseLong(versionString);
		}
		
		setIndexEntity(indexEntityId, indexVersion);
		
		setStyleType(value.get(STYLE_TYPE_KEY).isString().stringValue());
		setStyleGlyphType(value.get(STYLE_GLYPH_TYPE_KEY).isString().stringValue());
		setStyleColor(value.get(STYLE_COLOR_KEY).isString().stringValue());
		setHeightPx(Integer.parseInt(value.get(STYLE_HEIGHT).isString().stringValue()));
		String sourceTypeString = value.get(SOURCE_TYPE).isString().stringValue();
		setSourceType(SourceType.valueOf(sourceTypeString));
	}
	
	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}

	public void setStyleGlyphType(String styleGlyphType) {
		this.styleGlyphType = styleGlyphType;
	}

	public void setStyleColor(String styleColor) {
		this.styleColor = styleColor;
	}
	
	public String getSourceName() {
		return sourceName;
	}
	public String getSourceURI() {
		return sourceURI;
	}
	public String getSourceIndexURI() {
		return indexSourceURI;
	}
	public String getStyleType() {
		return styleType;
	}
	public String getStyleGlyphType() {
		return styleGlyphType;
	}
	public String getStyleColor() {
		return styleColor;
	}
	public int getHeightPx() {
		return heightPx;
	}
	
	public SourceType getSourceType() {
		return sourceType;
	}
	
	public String getEntityId() {
		return entityId;
	}

	public void setEntity(String entityId, Long version) {
		this.entityId = entityId;
		this.version = version;
	}

	public String getIndexEntityId() {
		return indexEntityId;
	}

	public void setIndexEntity(String indexEntityId, Long indexVersion) {
		this.indexEntityId = indexEntityId;
		this.indexVersion = indexVersion;
	}
	
	public Long getVersion() {
		return version;
	}
	
	public Long getIndexVersion() {
		return indexVersion;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setHeightPx(int heightPx) {
		this.heightPx = heightPx;
	}
	
	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}
	
	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}
	
	public void setIndexSourceURI(String indexSourceURI) {
		this.indexSourceURI = indexSourceURI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + heightPx;
		result = prime * result
				+ ((indexEntityId == null) ? 0 : indexEntityId.hashCode());
		result = prime * result
				+ ((indexSourceURI == null) ? 0 : indexSourceURI.hashCode());
		result = prime * result
				+ ((indexVersion == null) ? 0 : indexVersion.hashCode());
		result = prime * result
				+ ((sourceName == null) ? 0 : sourceName.hashCode());
		result = prime * result
				+ ((sourceType == null) ? 0 : sourceType.hashCode());
		result = prime * result
				+ ((sourceURI == null) ? 0 : sourceURI.hashCode());
		result = prime * result
				+ ((styleColor == null) ? 0 : styleColor.hashCode());
		result = prime * result
				+ ((styleGlyphType == null) ? 0 : styleGlyphType.hashCode());
		result = prime * result
				+ ((styleType == null) ? 0 : styleType.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BiodallianceSource other = (BiodallianceSource) obj;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (heightPx != other.heightPx)
			return false;
		if (indexEntityId == null) {
			if (other.indexEntityId != null)
				return false;
		} else if (!indexEntityId.equals(other.indexEntityId))
			return false;
		if (indexSourceURI == null) {
			if (other.indexSourceURI != null)
				return false;
		} else if (!indexSourceURI.equals(other.indexSourceURI))
			return false;
		if (indexVersion == null) {
			if (other.indexVersion != null)
				return false;
		} else if (!indexVersion.equals(other.indexVersion))
			return false;
		if (sourceName == null) {
			if (other.sourceName != null)
				return false;
		} else if (!sourceName.equals(other.sourceName))
			return false;
		if (sourceType != other.sourceType)
			return false;
		if (sourceURI == null) {
			if (other.sourceURI != null)
				return false;
		} else if (!sourceURI.equals(other.sourceURI))
			return false;
		if (styleColor == null) {
			if (other.styleColor != null)
				return false;
		} else if (!styleColor.equals(other.styleColor))
			return false;
		if (styleGlyphType == null) {
			if (other.styleGlyphType != null)
				return false;
		} else if (!styleGlyphType.equals(other.styleGlyphType))
			return false;
		if (styleType == null) {
			if (other.styleType != null)
				return false;
		} else if (!styleType.equals(other.styleType))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	
}

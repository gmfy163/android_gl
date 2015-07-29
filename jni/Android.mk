LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := opengl_es
LOCAL_LDLIBS := -lGLESv1_CM -lGLESv2

FREETYPE_SRC_PATH := ./

LOCAL_CFLAGS := -Wall \
		-Wextra \
		-DANDROID_NDK \
		-DFT2_BUILD_LIBRARY=1 \
		-DFTGLES2

LOCAL_C_INCLUDES := $(LOCAL_PATH)/include_all \
		$(LOCAL_PATH)/include \
		$(LOCAL_PATH)src \
		$(LOCAL_PATH)/src2 \
		$(LOCAL_PATH)/src2/iGLU-1.0.0/include
		
#LOCAL_C_INCLUDES += $(shell ls -FR $(LOCAL_C_INCLUDES) | grep $(LOCAL_PATH)/$ | sed "s/:/ /g" )		

LOCAL_SRC_FILES := interface.cpp \
	opengl_es.cpp \
	$(FREETYPE_SRC_PATH)src/autofit/autofit.c \
	$(FREETYPE_SRC_PATH)src/base/basepic.c \
	$(FREETYPE_SRC_PATH)src/base/ftapi.c \
	$(FREETYPE_SRC_PATH)src/base/ftbase.c \
	$(FREETYPE_SRC_PATH)src/base/ftbbox.c \
	$(FREETYPE_SRC_PATH)src/base/ftbitmap.c \
	$(FREETYPE_SRC_PATH)src/base/ftdbgmem.c \
	$(FREETYPE_SRC_PATH)src/base/ftdebug.c \
	$(FREETYPE_SRC_PATH)src/base/ftglyph.c \
	$(FREETYPE_SRC_PATH)src/base/ftinit.c \
	$(FREETYPE_SRC_PATH)src/base/ftpic.c \
	$(FREETYPE_SRC_PATH)src/base/ftstroke.c \
	$(FREETYPE_SRC_PATH)src/base/ftsynth.c \
	$(FREETYPE_SRC_PATH)src/base/ftsystem.c \
	$(FREETYPE_SRC_PATH)src/cff/cff.c \
	$(FREETYPE_SRC_PATH)src/pshinter/pshinter.c \
	$(FREETYPE_SRC_PATH)src/psnames/psnames.c \
	$(FREETYPE_SRC_PATH)src/raster/raster.c \
	$(FREETYPE_SRC_PATH)src/sfnt/sfnt.c \
	$(FREETYPE_SRC_PATH)src/smooth/smooth.c \
	$(FREETYPE_SRC_PATH)src/truetype/truetype.c \
	$(FREETYPE_SRC_PATH)src2/FTBuffer.cpp \
	$(FREETYPE_SRC_PATH)src2/FTCharmap.cpp \
	$(FREETYPE_SRC_PATH)src2/FTContour.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFace.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTBitmapFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTBufferFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTFontGlue.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTOutlineFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTPixmapFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTPolygonFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTFont/FTTextureFont.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTBitmapGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTBufferGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGL/ftgles2Glue.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTGlyphGlue.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTOutlineGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTPixmapGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTPolygonGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyph/FTTextureGlyph.cpp \
	$(FREETYPE_SRC_PATH)src2/FTGlyphContainer.cpp \
	$(FREETYPE_SRC_PATH)src2/FTLayout/FTLayout.cpp \
	$(FREETYPE_SRC_PATH)src2/FTLayout/FTLayoutGlue.cpp \
	$(FREETYPE_SRC_PATH)src2/FTLayout/FTSimpleLayout.cpp \
	$(FREETYPE_SRC_PATH)src2/FTLibrary.cpp \
	$(FREETYPE_SRC_PATH)src2/FTPoint.cpp \
	$(FREETYPE_SRC_PATH)src2/FTSize.cpp \
	$(FREETYPE_SRC_PATH)src2/FTVectoriser.cpp \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/dict.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/geom.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/memalloc.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/mesh.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/normal.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/priorityq.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/render.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/sweep.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/tess.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libtess/tessmono.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libutil/error.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libutil/glue.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libutil/project.c \
	$(FREETYPE_SRC_PATH)src2/iGLU-1.0.0/libutil/registry.c

include $(BUILD_SHARED_LIBRARY)

#include <jni.h>
#include <GLES2/gl2.h>
#include <GLES2/gl2ext.h>
#include <stdlib.h>
//#include "common.h"

// 全局变量
static GLuint _gProgramObject;

static GLfloat vVertices[] = { -0.5f, 0.5f, 0.5f, 0.5f, 0.5f, -0.5f, -0.5f,
		-0.5f };
static GLfloat vVertices2[] = { -0.5f, 0.5f, 0.5f, 0.5f, 0.5f, -0.5f, -0.5f,
		-0.5f };
static GLubyte indices[] = { 0, 1, 2, 0, 2, 3 };

static GLfloat vVertices_line[] = { 0.0f, 1.0f, 0.0f, -1.0f };

static GLubyte indices_line[] = { 0, 1 };

//
//
static GLuint loadShader(GLenum shaderType, const char* pSource) {
	GLuint shader;
	GLint compiled;

	//  创建着色器
	shader = glCreateShader(shaderType);
	if (shader) {
		glShaderSource(shader, 1, &pSource, NULL);
		glCompileShader(shader);
		glGetShaderiv(shader, GL_COMPILE_STATUS, &compiled);
		if (!compiled) {
			GLint infoLen = 0;
			glGetShaderiv(shader, GL_INFO_LOG_LENGTH, &infoLen);
			if (infoLen > 1) {
				char* infoLog = (char*) malloc(infoLen);
				glGetShaderInfoLog(shader, infoLen, NULL, infoLog);
				//LOGE("Could not compile shader %d:\n%s\n",
				//  shaderType, infoLog);
				free(infoLog);
				glDeleteShader(shader);
				shader = 0;
			}
		}
	}
	return shader;
}

void gles_init() {
	const char vShaderStr[] = "attribute vec4 vPosition;                   \n"
			"void main()                                 \n"
			"{                                           \n"
			"    gl_Position = vPosition;                \n"
			"}                                           \n";

	const char fShaderStr[] = "precision mediump float;                    \n"
			"void main()                                 \n"
			"{                                           \n"
			"    gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);\n"
			"}                                           \n";

	GLuint vertexShader;
	GLuint fragmentShader;
	GLuint programObject;
	GLint linked;

	// load vetex / fragment shaders
	vertexShader = loadShader(GL_VERTEX_SHADER, vShaderStr);
	fragmentShader = loadShader(GL_FRAGMENT_SHADER, fShaderStr);

	//
	programObject = glCreateProgram();

	glAttachShader(programObject, vertexShader);
	glAttachShader(programObject, fragmentShader);

	//
	glBindAttribLocation(programObject, 0, "vPosition");

	//
	glLinkProgram(programObject);

	glGetProgramiv(programObject, GL_LINK_STATUS, &linked);
	if (!linked) {
		//LOGE("error when link program");
		glDeleteProgram(programObject);
	}

	_gProgramObject = programObject;
	glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
	return;
}

//
//
//
void gles_draw() {
	static bool bx = true;
	static bool bx2 = true;
	glClear(GL_COLOR_BUFFER_BIT);

	// del
	if (bx) {
		if (vVertices[0] + 0.01 > 1) {
			bx = !bx;
		}
	} else {
		if (vVertices[0] - 0.01 < -1) {
			bx = !bx;
		}
	}

	if (bx2) {
		if (vVertices[2] - 0.01 < -1) {
			bx2 = !bx2;
		}
	} else {
		if (vVertices[2] - 0.01 > 1) {
			bx2 = !bx2;
		}
	}

	if (bx) {
		vVertices[0] += 0.01;
	} else {
		vVertices[0] -= 0.01;
	}

	if (bx2) {
		vVertices[2] -= 0.01;
	} else {
		vVertices[2] += 0.01;
	}

	glUseProgram(_gProgramObject);
	glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 0, vVertices);
	glEnableVertexAttribArray(0);
	//glDrawArrays(GL_QUADS, 0, 4);
	glLineWidth(10);
	glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_BYTE, indices);
	glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 0, vVertices_line);
	glDrawElements(GL_LINES, 2, GL_UNSIGNED_BYTE, indices_line);
	return;
}
void gles_draw2() {
//	return;
	static bool bx = true;
	static bool bx2 = true;
	glClear(GL_COLOR_BUFFER_BIT);

	// del
	if (bx) {
		if (vVertices2[4] + 0.01 > 1) {
			bx = !bx;
		}
	} else {
		if (vVertices2[4] - 0.01 < -1) {
			bx = !bx;
		}
	}

	if (bx2) {
		if (vVertices2[6] - 0.01 < -1) {
			bx2 = !bx2;
		}
	} else {
		if (vVertices2[6] - 0.01 > 1) {
			bx2 = !bx2;
		}
	}

	if (bx) {
		vVertices2[4] += 0.01;
	} else {
		vVertices2[4] -= 0.01;
	}

	if (bx2) {
		vVertices2[6] -= 0.01;
	} else {
		vVertices2[6] += 0.01;
	}

	glUseProgram(_gProgramObject);
	glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 0, vVertices2);
	glEnableVertexAttribArray(0);
	//glDrawArrays(GL_QUADS, 0, 4);
	glLineWidth(10);
	glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_BYTE, indices);
	glVertexAttribPointer(0, 2, GL_FLOAT, GL_FALSE, 0, vVertices_line);
	glDrawElements(GL_LINES, 2, GL_UNSIGNED_BYTE, indices_line);
	return;
}
void gles_change(int iw, int ih) {
	glViewport(0, 0, iw, ih);
	return;
}

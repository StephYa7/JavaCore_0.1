SRC_DIR := src
OUT_DIR := out
DOC_DIR := doc

JC := javac
JDOC := javadoc
JSRC := -sourcepath $(SRC_DIR)/main/java/
JCLASS := -cp ./$(OUT_DIR)
JCDEST := -d ./$(OUT_DIR)
JDOCDEST := -d $(DOC_DIR)
MAIN_SOURCE := main/java/st/example/Main
MAIN_CLASS := st.example.Main

all:
	${JC} ${JSRC} ${JCDEST} ${SRC_DIR}/${MAIN_SOURCE}.java

clean:
	rm -R ${OUT_DIR}

run:
	cd out && java ${MAIN_CLASS}

docs:
	${JDOC}) ${JDOCDEST} ${JSRC} ${JCLASS} -subpackages ru
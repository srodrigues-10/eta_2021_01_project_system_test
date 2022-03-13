package system.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralFuncions {

    public static void esperaFixa(int valor) {
        try {
            Thread.sleep(valor);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String geradorCPF(boolean comPontuacao) {

        int digito1 = 0;
        int digito2 = 0;
        int resto = 0;
        String nDigResult;
        String numerosContatenados;
        String numeroGerado;

        SecureRandom numeroAleatorio = new SecureRandom();

        // numeros gerados
        int n1 = numeroAleatorio.nextInt(10);
        int n2 = numeroAleatorio.nextInt(10);
        int n3 = numeroAleatorio.nextInt(10);
        int n4 = numeroAleatorio.nextInt(10);
        int n5 = numeroAleatorio.nextInt(10);
        int n6 = numeroAleatorio.nextInt(10);
        int n7 = numeroAleatorio.nextInt(10);
        int n8 = numeroAleatorio.nextInt(10);
        int n9 = numeroAleatorio.nextInt(10);

        int soma = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        int valor = (soma / 11) * 11;

        digito1 = soma - valor;

        // Primeiro resto da divisão por 11.
        resto = (digito1 % 11);

        if (digito1 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        int soma2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        int valor2 = (soma2 / 11) * 11;

        digito2 = soma2 - valor2;

        // Primeiro resto da divisão por 11.
        resto = (digito2 % 11);

        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        // Conctenando os numeros

        if (comPontuacao) {
            numerosContatenados = n1 + n2 + n3 + "." + n4 + n5 + n6 + "." + n7 + n8 + n9 + "-";
        } else {
            numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4)
                    + String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8)
                    + String.valueOf(n9);
        }

        // Concatenando o primeiro resto com o segundo.
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        numeroGerado = numerosContatenados + nDigResult;

        return numeroGerado;
    }

    public static String getDataHoraAtual() {
        // Criação das Variáveis
        Date dataAtual;
        String dataAtualFormatada;

        // Instanciando objetos
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");

        // Setando valores nas variáveis
        dataAtual = new Date();
        dataAtualFormatada = format.format(dataAtual);

        return dataAtualFormatada;
    }

    /*
     * Função: encontrarColuna(String arqExcelFile, String column, String aba)
     *
     * Realiza a busca pela coluna passada por parametro na aba tbm passada via
     * parametro e retorna o numero dessa coluna, caso nao seja encontrada,
     * retornara -1. arquivo de um determinado diretorio de origem para um
     * determinado diretorio de destino.
     *
     * Parametros:
     *
     * String arqExcelFile -> Recebera o caminho do arquivo xlsx
     * String column -> Coluna que sera procurada
     * String aba -> Aba pesquisada, caso seja passado uma string vazia (""), buscara na primeira aba
     *
     */
    private static int encontrarColuna(String arqExcelFile, String column, String aba) {

        File excelFile = new File(arqExcelFile);
        boolean encontrado = false;
        int cols = 0;
        XSSFWorkbook workbook;

        // Realiza a busca pela coluna
        try (FileInputStream fis = new FileInputStream(excelFile)) {

            // Inicia a planilha
            workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet;

            // Valida aba que sera aberta
            if(aba.length() == 0) {
                sheet = workbook.getSheetAt(0);
            }else {
                sheet = workbook.getSheet(aba);
            }
            Iterator<Row> rowIt = sheet.iterator();

            // Captura a posicao da coluna
            Row row = rowIt.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = null;
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell.toString().equals(column)) {
                    encontrado = true;
                    break;
                } else {
                    cols++;
                }
            }

            // Fecha o workbook
            workbook.close();

        } catch (Exception e) {
            System.out.println("Erro ao encontrar coluna da captura do XLSX.");
        }

        // Retorna a coluna caso tenha sido encontrada
        if(encontrado) {
            return cols;
        }else {
            return -1;
        }

    }

    public static String retornarCellEmString(Cell cell) {
        try {
            return cell.getStringCellValue();
        }catch(IllegalStateException e) {
            return Integer.toString((int) cell.getNumericCellValue());
        }
    }

    public static String capturarValorDoXLSX(String arqExcelFile, String column) {

        // Encontra coluna
        int cols = encontrarColuna(arqExcelFile, column, "");

        // Cria o arquivo do Excel
        File excelFile = new File(arqExcelFile);

        try (FileInputStream fis = new FileInputStream(excelFile)){

            // Inicia a planilha
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIt = sheet.iterator();

            // Captura a posicao da coluna
            Row row = rowIt.next();

            // Variavel de linhas
            int rows = 0;

            // Valida que encontrou um resultado
            if (cols!=-1) {

                // Salva os valores e captura o final
                row = sheet.getRow(rows + 1);
                Cell cell1 = row.getCell(cols);

                // Fecha a planilha de input
                workbook.close();

                // Retorna o valor da celula em String
                return retornarCellEmString(cell1);

            } else {

                // Fecha a planilha de input
                workbook.close();

                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao abrir a planilha de inputs: " + e + "  Coluna: " + column + "  Planilha: " + excelFile);
            return "";
        }
    }

    public static void alterarValorDoXLSX(String arqExcelFile, String column, String valor) {

        // Encontra coluna
        int cols = encontrarColuna(arqExcelFile, column, "");

        // Cria o arquivo do Excel
        File excelFile = new File(arqExcelFile);

        try (FileInputStream fis = new FileInputStream(excelFile)){

            // Inicia a planilha
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIt = sheet.iterator();

            // Captura a posicao da coluna
            int rows = 0;
            Row row = rowIt.next();

            // Salva os valores
            row = sheet.getRow(rows + 1);
            Cell cell1 = row.getCell(cols);

            // Altera o valor
            cell1.setCellValue(valor);

            // Salva as alteracoes
            FileOutputStream fileOut = new FileOutputStream(excelFile);
            workbook.write(fileOut);
            fileOut.close();

            // Fecha a planilha de input
            workbook.close();

        } catch (Exception e) {
            System.out.println("Erro ao alterar a planilha: " + arqExcelFile + "   Coluna: " + column + "     " + e);
        }

    }

}

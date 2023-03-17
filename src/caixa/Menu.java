package caixa;
/**
 *
 * @author Alex Jr
 */

import javax.swing.JOptionPane;

public class Menu {

    public static void main(String[] args) {
        
        int qtdDeNotas;
        int opcao;
        String nome;

        CaixaEletrônico caixa = new CaixaEletrônico();

        JOptionPane.showMessageDialog(null, "------Caixa Eletrônico------");
        JOptionPane.showMessageDialog(null, "      Seja Bem Vindo!!!");
        nome = (JOptionPane.showInputDialog("Informe seu nome"));

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Olá " + nome + "!" + "\nSelecione uma opção:\n"
                    + "  1-Depositar \n  2-Sacar \n  3-Créditos \n  4-Sair"));
            switch (opcao) {
                case 1:

                    int qtdNota = Integer.parseInt(JOptionPane.showInputDialog("Notas de R$ 2: "));
                    caixa.repor(2, qtdNota);

                    qtdNota = Integer.parseInt(JOptionPane.showInputDialog("Notas de R$ 5: "));
                    caixa.repor(5, qtdNota);

                    qtdNota = Integer.parseInt(JOptionPane.showInputDialog("Notas de R$ 10: "));
                    caixa.repor(10, qtdNota);
                    qtdNota = Integer.parseInt(JOptionPane.showInputDialog("Notas de R$ 20: "));
                    caixa.repor(20, qtdNota);

                    qtdNota = Integer.parseInt(JOptionPane.showInputDialog("Notas de R$ 50: "));
                    caixa.repor(50, qtdNota);

                    qtdNota = Integer.parseInt(JOptionPane.showInputDialog("Notas de R$ 100: "));
                    caixa.repor(100, qtdNota);

                    JOptionPane.showMessageDialog(null, "Reposicao efetuada com sucesso!");
                    JOptionPane.showMessageDialog(null, "Saldo atual         : R$ " + caixa.consultarSaldo());

                    break;
                case 2:

                    float quantia = Integer.parseInt(JOptionPane.showInputDialog("Informe "
                            + "Valor a Sacar: "));
                    boolean flag = caixa.sacar(quantia);
                    if (flag == false) {
                        JOptionPane.showMessageDialog(null, "Nao existem notas suficientes no Caixa para esta quantia!\n");
                    } else {
                        JOptionPane.showMessageDialog(null, "Saque de R$" + quantia + " efetuado com sucesso!\n");
                        JOptionPane.showMessageDialog(null, "Saldo atual         : R$ " + caixa.consultarSaldo());

                        JOptionPane.showMessageDialog(null, "Notas de R$ 2        : \n" + caixa.mostraQtdTipoNotas(2));
                        JOptionPane.showMessageDialog(null, "Notas de R$ 5        : \n" + caixa.mostraQtdTipoNotas(5));
                        JOptionPane.showMessageDialog(null, "Notas de R$ 10       : \n" + caixa.mostraQtdTipoNotas(10));
                        JOptionPane.showMessageDialog(null, "Notas de R$ 20       : \n" + caixa.mostraQtdTipoNotas(20));
                        JOptionPane.showMessageDialog(null, "Notas de R$ 50       : \n" + caixa.mostraQtdTipoNotas(50));
                        JOptionPane.showMessageDialog(null, "Notas de R$ 100      : \n" + caixa.mostraQtdTipoNotas(100));

                    }

                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Feito Por Alex Júnior,IFRJ,3°Periodo,Java\n");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Operação Finalizada, Volte sempre. Obrigado!\n");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "\nOperação inválida!");
            }

        } while (opcao != 4);

    }

}

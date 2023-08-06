import br.com.ifsp.googleagenda.entity.Evento;
import br.com.ifsp.googleagenda.entity.Lembrete;
import br.com.ifsp.googleagenda.entity.Tarefa;
import br.com.ifsp.googleagenda.service.EventoService;
import br.com.ifsp.googleagenda.service.LembreteService;
import br.com.ifsp.googleagenda.service.TarefaService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GoogleAgendaApp {
    private static EventoService eventoService = new EventoService();
    private static TarefaService tarefaService = new TarefaService();
    private static LembreteService lembreteService = new LembreteService();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        int escolha;
        do {
            System.out.println("\nSelecione uma opção, ou 0 para sair:");

            System.out.println("############ EVENTOS ##########");
            System.out.println("1 - Cadastrar Evento");
            System.out.println("2 - Listar Eventos");
            System.out.println("3 - Editar evento");
            System.out.println("4 - Buscar evento pelo Id");
            System.out.println("5 - Excluir Evento");

            System.out.println("############ TAREFAS ##########");
            System.out.println("6 - Cadastrar Tarefa");
            System.out.println("7 - Listar Tarefas");
            System.out.println("8 - Editar tarefa");
            System.out.println("9 - Buscar tarefa pelo Id");
            System.out.println("10 - Excluir Tarefa");

            System.out.println("############ LEMBRETES ##########");
            System.out.println("11 - Cadastrar Lembrete");
            System.out.println("12 - Listar Lembretes");
            System.out.println("13 - Editar Lembrete");
            System.out.println("14 - Buscar lembrete pelo Id");
            System.out.println("15 - Excluir Lembrete");

            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    cadastrarEvento();
                    break;
                case 2:
                    listarEventos();
                    break;
                case 3:
                    editarEvento();
                    break;
                case 4:
                    buscarEventoId();
                    break;
                case 5:
                    excluirEvento();
                    break;
                case 6:
                    cadastrarTarefa();
                    break;
                case 7:
                    listarTarefas();
                    break;
                case 8:
                    editarTarefa();
                    break;
                case 9:
                    buscarTarefaId();
                    break;
                case 10:
                    excluirTarefa();
                    break;
                case 11:
                    cadastrarLembrete();
                    break;
                case 12:
                    listarLembretes();
                    break;
                case 13: 
                    editarLembrete();
                    break;
                case 14: 
                    buscarLembreteId();
                    break;
                case 15:
                    excluirLembrete();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    private static void editarLembrete() {
        System.out.println("Digite o ID do lembrete que deseja editar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo título do lembrete:");
        String novoTitulo = scanner.nextLine();

        System.out.println("Digite a nova data e hora do lembrete (formato dd/MM/yyyy HH:mm):");
        String entradaNovaDataHora = scanner.nextLine();
        LocalDateTime novaDataHora = LocalDateTime.parse(entradaNovaDataHora, formatter);

        lembreteService.editarLembrete(id, novoTitulo, novaDataHora);
        System.out.println("Lembrete editado com sucesso!");
    }


    private static void editarTarefa() {
        System.out.println("Digite o ID da tarefa que deseja editar:");
        Integer id = scanner.nextInt();
//        scanner.nextLine();

        System.out.println("Digite o novo título da tarefa:");
        String novoTitulo = scanner.nextLine();

        System.out.println("Digite a nova data e hora da tarefa (formato dd/MM/yyyy HH:mm):");
        String entradaNovaDataHora = scanner.nextLine();
        LocalDateTime novaDataHora = LocalDateTime.parse(entradaNovaDataHora, formatter);

        System.out.println("Digite a nova descrição da tarefa:");
        String novaDescricao = scanner.nextLine();

        System.out.println("A tarefa se repete? (true/false):");
        boolean novoRepete = scanner.nextBoolean();

        tarefaService.editarTarefa(id, novoTitulo, novaDataHora, novaDescricao, novoRepete);
        System.out.println("Tarefa editada com sucesso!");
    }


    private static void editarEvento() {
        System.out.println("Digite o ID do evento que deseja editar:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo título do evento:");
        String novoTitulo = scanner.nextLine();

        System.out.println("Digite a nova data e hora de início do evento (formato dd/MM/yyyy HH:mm):");
        String entradaNovaDataHoraInicio = scanner.nextLine();
        LocalDateTime novaDataHoraInicio = LocalDateTime.parse(entradaNovaDataHoraInicio, formatter);

        System.out.println("Digite a nova descrição do evento:");
        String novaDescricao = scanner.nextLine();

        System.out.println("Digite o novo local do evento (ou deixe vazio caso não tenha local):");
        String novoLocal = scanner.nextLine();

        System.out.println("Digite a nova data e hora de fim do evento (formato dd/MM/yyyy HH:mm):");
        String entradaNovaDataHoraFim = scanner.nextLine();
        LocalDateTime novaDataHoraFim = LocalDateTime.parse(entradaNovaDataHoraFim, formatter);

        eventoService.editarEvento(id, novoTitulo, novaDataHoraInicio, novaDescricao, novoLocal, novaDataHoraFim);
        System.out.println("Evento editado com sucesso!");
    }


    private static void buscarLembreteId() {
        System.out.println("Digite o ID do lembrete que deseja buscar:");
        Integer id = scanner.nextInt();
        Lembrete lembrete = lembreteService.buscarLembrete(id);
        if (lembrete != null) {
            System.out.println("Lembrete encontrado:");
            System.out.println(lembreteService.formatarLembrete(lembrete));
        } else {
            System.out.println("Lembrete não encontrado com o ID informado.");
        }
    }

    private static void buscarEventoId() {
        System.out.println("Digite o ID do evento que deseja buscar:");
        Integer id = scanner.nextInt();
        Evento evento = eventoService.buscarEvento(id);
        if (evento != null) {
            System.out.println("Evento encontrado:");
            System.out.println(eventoService.formatarEvento(evento));
        } else {
            System.out.println("Evento não encontrado com o ID informado.");
        }
    }

    private static void excluirEvento() {
        System.out.println("Digite o ID do evento que deseja excluir:");
        Integer id = scanner.nextInt();
        eventoService.excluirEvento(id);
        System.out.println("Evento excluído com sucesso!");
    }

    private static void buscarTarefaId() {
        System.out.println("Digite o ID da tarefa que deseja buscar:");
        Integer id = scanner.nextInt();
        Tarefa tarefa = tarefaService.buscarTarefa(id);
        if (tarefa != null) {
            System.out.println("Tarefa encontrada:");
            System.out.println(tarefaService.formatarTarefa(tarefa));
        } else {
            System.out.println("Tarefa não encontrada com o ID informado.");
        }
    }

    private static void excluirTarefa() {
        System.out.println("Digite o ID da tarefa que deseja excluir:");
        Integer id = scanner.nextInt();
        tarefaService.excluirTarefa(id);
        System.out.println("Tarefa excluída com sucesso!");
    }

    private static void excluirLembrete() {
        System.out.println("Digite o ID do lembrete que deseja excluir:");
        Integer id = scanner.nextInt();
        lembreteService.excluirLembrete(id);
        System.out.println("Lembrete excluído com sucesso!");
    }


    private static void cadastrarEvento() {
        System.out.println("Digite um ID para o evento:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o título do evento:");
        String titulo = scanner.nextLine();

        System.out.println("Digite a descrição do evento:");
        String descricao = scanner.nextLine();

        System.out.println("Digite o local do evento (ou deixe vazio caso não tenha local):");
        String local = scanner.nextLine();

        System.out.println("Digite a data e hora de início (formato dd/MM/yyyy HH:mm):");
        String entradaDataHoraInicio = scanner.nextLine();
        LocalDateTime dataHoraInicio = LocalDateTime.parse(entradaDataHoraInicio, formatter);

        System.out.println("Digite a data e hora de fim (formato dd/MM/yyyy HH:mm):");
        String entradaDataHoraFim = scanner.nextLine();
        LocalDateTime dataHoraFim = LocalDateTime.parse(entradaDataHoraFim, formatter);

        eventoService.cadastrarEvento(id, titulo, dataHoraInicio, descricao, local, dataHoraFim);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos() {
        eventoService.listarTodosEventos();
    }

    private static void cadastrarTarefa() {
        System.out.println("Digite um ID para a tarefa:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o título da tarefa:");
        String titulo = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa:");
        String descricao = scanner.nextLine();

        System.out.println("Digite a data e hora (formato dd/MM/yyyy HH:mm):");
        String entradaDataHora = scanner.nextLine();
        LocalDateTime dataHora = LocalDateTime.parse(entradaDataHora, formatter);

        System.out.println("A tarefa se repete? (true/false):");
        boolean repete = scanner.nextBoolean();

        tarefaService.cadastrarTarefa(id, titulo, dataHora, descricao, repete);
        System.out.println("Tarefa cadastrada com sucesso!");
    }

    private static void listarTarefas() {
        tarefaService.listarTodosTarefas();
    }

    private static void cadastrarLembrete() {
        System.out.println("Digite um Id para o lembrete:");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o título do lembrete:");
        String titulo = scanner.nextLine();

        System.out.println("Digite a data e hora (formato dd/MM/yyyy HH:mm):");
        String entradaUsuario = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(entradaUsuario, formatter);

        lembreteService.criarLembrete(id, titulo, dataHora);
        System.out.println("Lembrete cadastrado com sucesso!");
    }

    private static void listarLembretes() {
        lembreteService.listarTodosLembretes();
    }
}


